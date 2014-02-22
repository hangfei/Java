package snipe;

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class Snipe extends JFrame {
    JPanel buttonPanel = new JPanel();
    JButton playButton = new JButton("Play");
    JButton pauseButton = new JButton("Pause");
    JButton resumeButton = new JButton("Resume");
    JButton quitButton = new JButton("Quit");
    static int defaultWindowSizeW = 800;
    static int defaultWindowSizeH = 800;
    Timer timer;

    Model model = new Model();
    View view = new View(model); // View must know about Model
    
    public static void main(String[] args) {
        Snipe snipe = new Snipe();
        snipe.init();
        snipe.setSize(defaultWindowSizeH, defaultWindowSizeW);
        snipe.setVisible(true);
    }
    
    public void init() {
        layOutComponents();
        attachListenersToComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Connect model and view
        model.addObserver(view);
        //model.generateComputerBalls();
    }
    private void layOutComponents() {
        setLayout(new BorderLayout());
        this.add(BorderLayout.SOUTH, buttonPanel);
        buttonPanel.add(playButton);
        buttonPanel.add(pauseButton);
        buttonPanel.add(resumeButton);
        buttonPanel.add(quitButton);
        pauseButton.setEnabled(false);
        resumeButton.setEnabled(false);
//        quitButton.setEnabled(false);
        this.add(BorderLayout.CENTER, view);
        
        //add focus manager
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());
    }
    private void attachListenersToComponents() {
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	//reset the status
            	model.resetBalls();
            	if(model.gameStatus()) {
            		timer.cancel();
            	}
            	
            	
                playButton.setEnabled(false);
                pauseButton.setEnabled(true);
                quitButton.setEnabled(true);
                model.gameStatusStart();
                model.addObserver(view);
                model.generateComputerBalls();
                timer = new Timer(true);
                timer.schedule(new Strobe(), 0, 40); // 25 times a second
            }
        });
        pauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            
                pauseButton.setEnabled(false);
                
                resumeButton.setEnabled(true);
                timer.cancel();
            }
        });//end of pauseButton
        
        resumeButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent event) {
        		pauseButton.setEnabled(true);
        		resumeButton.setEnabled(false);
        		view.getPausedTime(true);
        		timer = new Timer(true);
        		timer.schedule(new Strobe(), 0, 40);

        	}
        });
        quitButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent event) {
                System.exit(0);
                
        		
//        		
//        		playButton.setEnabled(true);
//        		pauseButton.setEnabled(false);
//        		resumeButton.setEnabled(false);
//        		quitButton.setEnabled(false);
//                model.gameStatusQuit();
//                //System.out.println(model.gameStatus());
//                timer.cancel();
//                model.resetBalls();
//                view.startInitialTimer = true;
        		//timer = new Timer(true);
        		
            
        	}
        });
    }

    /**
     * key listener dispatcher
     * listen to the global keyboard
     *
     * @author hangfei
     *
     */
    private class MyDispatcher implements KeyEventDispatcher {
    	 //TODO better to add a slow down the ball button
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
//            if (e.getKeyCode() == KeyEvent.VK_UP && pauseButton.isEnabled()) {
//            	model.ballUserControl.changeSpeed(0, -1);
//            	//System.out.println("1test1");
//            }
//            if (e.getKeyCode() == KeyEvent.VK_DOWN && pauseButton.isEnabled()) {
//            	model.ballUserControl.changeSpeed(0, +1);
//                //System.out.println("2test2");
//            }
//            if(e.getKeyCode() == KeyEvent.VK_LEFT && pauseButton.isEnabled()) {
//            	model.ballUserControl.changeSpeed(-1, 0);
//                //System.out.println("Left arrow pressed.");
//            }
//            if(e.getKeyCode() == KeyEvent.VK_RIGHT && pauseButton.isEnabled()) {
//            	model.ballUserControl.changeSpeed(1, 0);
//                //System.out.println("Right arrow pressed.")
//            }
        	if(pauseButton.isEnabled()){
        		if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_I 
        				|| e.getKeyCode() == KeyEvent.VK_W){
        			model.ballUserControl.changeSpeed(0, -1);
        		}
        		else if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_K 
        				|| e.getKeyCode() == KeyEvent.VK_S){
                 	model.ballUserControl.changeSpeed(0, +1);
                     //System.out.println("2test2");
                 } 
        		else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_J 
        				|| e.getKeyCode() == KeyEvent.VK_A){
                 	model.ballUserControl.changeSpeed(-1, 0);
                 }
        		else if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D 
        				|| e.getKeyCode() == KeyEvent.VK_L){
                  	model.ballUserControl.changeSpeed(1, 0);
              
                }
        	
            
        }//end of if
        	return false;
        }//end of dispatchKeyEvent method
    }//end of the MyDispatcher class
    
    
    /**
     * the task
     * @author hangfei
     *
     */
    private class Strobe extends TimerTask {
        public void run() {
        	if(!model.ballsAllDead()) {
        		model.setLimits(view.getWidth(), view.getHeight());
                model.makeOneStep();
                model.collideAndStop();
                model.ballColors();
        	}
        	else if(model.ballsAllDead()) {
//            	quitButton.setEnabled(false);
            	playButton.setEnabled(true);
            	pauseButton.setEnabled(false);
            	resumeButton.setEnabled(false);
            	
            }
        }
    }
}