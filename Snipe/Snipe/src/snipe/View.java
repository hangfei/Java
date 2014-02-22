package snipe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

class View extends JPanel implements Observer {
    Model model;
    public boolean startInitialTimer = true;
    Calendar tStart;
    Calendar tNow;
    Calendar tPause;
    long t1 = 0;
    long t2 = 0;
    long t3 = 0;
    long pausedTime;
    String timerString;
	public boolean isPaused = false;
  
    View(Model model) {
        this.model = model;
    }

    /**
     * the timer
     */
    @Override
    public void paintComponent(Graphics g) {
       //super.paintComponent(g);
       //Graphics2D g2 = (Graphics2D) g;
    	//set the font and word color
    	Font f = new Font("Helvetica", Font.PLAIN, 20);
        g.setFont(f);
        g.setColor(Color.BLUE);
        if(model.gameStatus() && !model.ballsAllDead()) {
    	   if(startInitialTimer) {
    		   tStart = Calendar.getInstance();
    		   t1= tStart.getTimeInMillis();	
    		   startInitialTimer = false;
    	   }
    	   else {
    		   //tStart = Calendar.getInstance();
    		   //t1 = tStart.getTimeInMillis();	
    	   }
    	   t1 = t1 + pausedTime;
    	   getPausedTime(false);
    	   tNow = Calendar.getInstance();
           t2 = tNow.getTimeInMillis();
           //System.out.println(t1);
           long timerSecond = (t2 - t1)/1000;
           long timerTenthSecond = (t2 - t1)/100%10;
           timerString = Long.toString(timerSecond) + " Sec " + timerTenthSecond;	
           g.drawString(timerString, 705, 20);
        }
        
    
          
        	
     
        
        else {
    	   g.drawString("0 Sec 0", 705, 20);
    	   startInitialTimer = true;
    	   //System.out.println("yesss");
        } 
    }
    
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        if(model.gameStatus()) {
        	 //You win
            if(model.ballsAllDead()) {
         	    g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());
                Font f = new Font("Helvetica", Font.PLAIN, 20);
                g.setFont(f);
                g.setColor(Color.RED);
                g.drawString("You win!" +
                		"Elapsed Time: " +
                		timerString, 300, 300);
            }
            else{
            	 //mainBall
                Color ballUserControlColor = new Color(model.ballUserControl.ballColorR, model.ballUserControl.ballColorG, model.ballUserControl.ballColorB);
                g.setColor(ballUserControlColor);
                g.fillRect(model.ballUserControl.getX(), model.ballUserControl.getY(),
                        model.ballUserControl.BALL_SIZE, model.ballUserControl.BALL_SIZE);

                //other balls
                //remove the ball when color reaches removeBallColor
                for(int i = 0; i < model.ballNumber; i++) {
            	   Color ballColor = new Color(model.ballArray[i].ballColorR, 
            			   model.ballArray[i].ballColorG, model.ballArray[i].ballColorB);
            	   if( !model.ballArray[i].isDead()) {
                	   g.setColor(ballColor);
                	   g.fillOval(model.ballArray[i].getX(), model.ballArray[i].getY(),
             	              model.ballArray[i].BALL_SIZE, model.ballArray[i].BALL_SIZE);
                   }  
                }//end of the for i
            }
        }
        else {
        	  g.setColor(Color.WHITE);
              g.fillRect(0, 0, getWidth(), getHeight());
              Font f = new Font("Helvetica", Font.PLAIN, 20);
              g.setFont(f);
              g.setColor(Color.BLUE);
              String startInfo1 = "Welcome!"; 
              String startInfo2 = "This is Snipe.";
              String startInfo3 = "\nPress \"Play\" to start the game.";
              String startInfo4 = "Author: Hangfei Lin && Chih-Chung Huang";
                  		
              g.drawString(startInfo1, getWidth()/2 - 300, getHeight()/2);
              g.drawString(startInfo2, getWidth()/2 - 300, getHeight()/2 + 30);
              g.drawString(startInfo3, getWidth()/2 - 300, getHeight()/2 + 60);
              g.drawString(startInfo4, getWidth()/2 - 300, getHeight()/2 + 120);
              
        }//end of if(model.gameStatus()) and else
       
       

       //the timer
       paintComponent(g);
       
   
    }//end of paint method

    public void update(Observable obs, Object arg) {
        repaint();
        
    }
    
    public void getPausedTime(boolean isPaused){
    	if(isPaused){
    		tPause = Calendar.getInstance();
    		pausedTime =  tPause.getTimeInMillis() - t2;
    	}
    	else{
    		pausedTime = 0;
    	}
    }
    
   
    
    public boolean checkPaused(){
    	return isPaused;
    }
}