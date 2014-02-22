package magic;
import javax.swing.*;


//?
//import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import javax.swing.event.*;
import java.awt.event.ActionListener;


/**
 * the main class
 * this is a magic square with GUI
 * you can make a smaller or bigger magic square(all odd dimension)
 * @author Hangfei Lin
 * @author PennID: hangfei
 * */
public class MagicSquareMaker extends JFrame {
	int currentSize = 3;
	JPanel magicSqPanel = new JPanel();
	private JButton largeButton = new JButton("Large");
	private JButton smallButton = new JButton("Small");

	/**
	 * main method
	 * run the gui
	 * the default dimension is 5
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MagicSquareMaker().makeGui(5);
		
	}
	
	/**
	 * make GUI of the magic square
	 * @param size the size of the magic square
	 * @no return
	 */
	private void makeGui(int size) {
		//close the application in the memory
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		JLabel textField1 = new JLabel("Hangfei Lin");
		//textField1.setToolTipText("Author");
		//add(new JLabel("  "),BorderLayout.NORTH);
		add(textField1, BorderLayout.NORTH);
		
		//make small and large buttons

		smallButton.addActionListener(new SmallListener());
		largeButton.addActionListener(new LargeListener());
		JPanel twoButton = new JPanel();
		twoButton.add(smallButton);
		twoButton.add(largeButton);
		add(twoButton, BorderLayout.SOUTH);
		
		addWindowListener(new Closer());	
		
		//create a magic square with "size" dimension
		//pass as parameters for fillPanel
		MagicSquare square = new MagicSquare(size);
		
		//??

		magicSqPanel.removeAll();
		fillPanel(magicSqPanel, square);


		//to make the window fit the size occupied by all the components
		pack();
		//set location to the middle
		setLocationRelativeTo(null);
		//set the panel visible
		setVisible(true);
	}
	
	/**
	 * close the window
	 * 
	 * */
    private class Closer extends WindowAdapter {
        public void windowClosing(WindowEvent we) {
        	//update();
        	setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        	JOptionPane.showMessageDialog(null, "Game Over", "Exit", JOptionPane.INFORMATION_MESSAGE);
        	dispose();
        }
    }
	
	/**
	 * the "large" button
	 * 
	 * */
	class LargeListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				MagicSquare square = new MagicSquare(currentSize+2);
				//JPanel magicSq = new JPanel();
				
				magicSqPanel.removeAll();
				
				
				fillPanel(magicSqPanel, square);
				//magicSqPanel.validate();
	
				if (currentSize != 1) {
					
					smallButton.setEnabled(true);
				}	
							
				//resize to fit
				pack();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				//To-do
			}

		}
	}
	
	/**
	 * the Small button
	 * need to handle the negative array exception
	 * */
	class SmallListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				MagicSquare square = new MagicSquare(currentSize-2);
				magicSqPanel.removeAll();
				
				fillPanel(magicSqPanel, square);
				

				//??
				//magicSqPanel.removeAll();
				magicSqPanel.validate();
				
				if (currentSize == 1) {
					
					smallButton.setEnabled(false);
					
				}	
				
				//resize to fit
				pack();
			}
			catch(NegativeArraySizeException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "The dimension can not be smaller than 1", "Notification", JOptionPane.WARNING_MESSAGE);
				//System.out.println("yes");
			}
			finally{
				//To-Do
				
			}
		}
	}


	
	/**
	 * fill the panel
	 * with the magic square
	 * @param panel is the JPanel
	 * @param square is a magic square with a certain dimension
	 * 
	 */
	private void fillPanel(JPanel panel, MagicSquare square) {
		panel.removeAll();
		panel.validate();
		currentSize = square.getSquareSize();
		panel.setLayout(new GridLayout(square.getSquareSize(),square.getSquareSize()));
		//System.out.println(square);
		String sNumber;
		for (int i = 0; i < square.getSquareSize(); i++) {
			for(int j=0; j < square.getSquareSize(); j++) {
				sNumber = "  " + Integer.toString(square.getMagicSquareArray()[i][j])+"  ";
				panel.add(new JLabel(sNumber));
			}
		}

		add(panel, BorderLayout.CENTER);
		panel.validate();
	}

}
