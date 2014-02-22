/**
 * *******************************************************************************
 *  Name:       Harinee Sekar, HangFei Lin
 *  PennKey:    harinee, hangfei
 *  Course:     CIT 590, Assignment 11-Cryptograms
 *  Files:      Cryptograms.java, CryptogramsMaker.java, CryptogramsMakerTest.java
 **********************************************************************************
 */

/**
 * 
 */
package cryptograms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * @author Hangfei Lin
 *
 */
public class Cryptograms extends JFrame{
	JPanel encodingPanel = new JPanel();
	private JButton newGame = new JButton("New Game");
	private JButton giveupButton = new JButton("GiveUp");
	private JButton quitButton = new JButton("Quit");
	
	private  JPanel controlPanel = new JPanel();
	private JButton hintButton = new JButton("Hint");
	JTextField decodeJText = new JTextField("Enter your decoding");
	
	String guiTitle = "Game Name";
	CryptogramsMaker cryptodata = new CryptogramsMaker();
	//the user key, the initial user key should be "abcd...."
	String alphaBet = "abcdefghijklmnopqrstuvwxyz";
	//the present user key, modified based on initial user key
	String initialBlankUserKey = "                          ";
	String nowUserKey = initialBlankUserKey;
	char[] nowUserKeyChar = initialBlankUserKey.toCharArray();
	//the random game key, the anser key
	char[] gameAnswerKey = cryptodata.encodeKey();
	//the orignal quote, the answer, not useful
	private String originalQuote = cryptodata.getPureQuote(cryptodata.readQuotesFile('p'));
	//the orignal quote, the answer
	private String currentAnswerQuote = originalQuote;
	//the encoded quote, the mystery
	String encodedQuote = (cryptodata.encodeString(currentAnswerQuote, gameAnswerKey));
	//the present decoded quote. 
	String nowDecodedQuote = new String(encodedQuote);
	JComboBox myJComboBox;
	JLabel statusLabel = new JLabel("Status Bar");
	boolean quitButtonConfirm = false;
	boolean giveupButtonConfirm = false;
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Cryptograms().makeGUI();
	}
	
	
	
	/**
	 * make the GUI
	 * 
	 * */
	
	public void makeGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		//Box box = new Box(BoxLayout.Y_AXIS);
		JLabel textField1 = new JLabel(guiTitle);
		add(textField1, BorderLayout.NORTH);
		//add(new JLabel("Yes"));
		
		//encoding panel
		//the display
		
		//String displayData = cryptodata.textAreaString(encodedQuote, nowUserKeyChar);
				
		//char[] keyArray = cryptodata.encodeKey();
		String startInfo = "Welcome to Cryptograms!Plase press New Game"; 
		makeEncodingPanel(encodingPanel, startInfo);
		add(encodingPanel, BorderLayout.CENTER);
		
		//Controll panel
		controlPanel.setLayout(new BorderLayout());
		JPanel upperControlPanel = new JPanel();
		//default is flow layout
		upperControlPanel.setLayout(new BorderLayout());
		//selcet category JComboBox
		myJComboBox = new JComboBox(new String[]{"Computer Humor (269)", 
										"Computer Profound/Serious (101)", "Fortune Cookies(69)", "Humorous (3643)",
						        		"Profound/Serious (5101)"} );
		upperControlPanel.add(myJComboBox, BorderLayout.WEST);
		 myJComboBox.addActionListener(new MyJComboBoxListener());
		 myJComboBox.setSize(1000, myJComboBox.getPreferredSize().height);;
		 myJComboBox.setEnabled(false);
		 
		//add status bar
		//upperControlPanel.add(statusLabel, BorderLayout.NORTH);
		 
		//decoding
		upperControlPanel.add(decodeJText, BorderLayout.CENTER);
		decodeJText.setMinimumSize(new Dimension(100,200));
		decodeJText.setEnabled(false);
		//decodeJText.getDocument().addDocumentListener(new MyJTextAreaListener());
		decodeJText.addActionListener(new MyJTextFieldListener());
		decodeJText.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
            	decodeJText.setText("");
            }
        });
		
		//hint
		upperControlPanel.add(hintButton, BorderLayout.EAST);
		hintButton.addActionListener(new MyHintButtonActionListener());
		controlPanel.add(upperControlPanel, BorderLayout.NORTH);
		
		//user control panel
		//smallButton.addActionListener(new SmallListener());
		//largeButton.addActionListener(new LargeListener());
		//JPanel controlPanel = new JPanel();
		
		controlPanel.add(newGame, BorderLayout.CENTER);
		newGame.addActionListener(new MyNewGameActionListener());
		controlPanel.add(giveupButton, BorderLayout.WEST);
		giveupButton.addActionListener(new MyGiveUpButtonActionListener());
		giveupButton.setEnabled(false);
		controlPanel.add(quitButton, BorderLayout.EAST);
		quitButton.addActionListener(new MyQuitButtonActionListener());
		//controlPanel.add(statusLabel, BorderLayout.SOUTH);
		
		add(controlPanel, BorderLayout.SOUTH);
		
		
		
		
		setLocationRelativeTo(null);
		pack();
		setVisible(true);
		
	}
	
	
	
	/**
	 * the encoding area GUI Displays
	 * 
	 * */
	public void makeEncodingPanel(JPanel jPanel, String displayData) {
		//String quoteLineOne = new String();
		//String quoteLineTwo = new String();
		//String quoteLineThree = new String();
		jPanel.removeAll();
		
		//default GUI
		jPanel.setLayout(new BorderLayout());
		JTextArea jTextAreaOne = new JTextArea(displayData);
		Font font = new Font("Monospaced", Font.TRUETYPE_FONT, 15);
		jTextAreaOne.setFont(font);
		//JLabel jLabelTwo = new JLabel("Use your head and your heart; it's");
		jTextAreaOne.setPreferredSize(new Dimension(350, 160));
		jPanel.add(jTextAreaOne, BorderLayout.CENTER);
		jPanel.add(statusLabel, BorderLayout.SOUTH);
		//jPanel.add(statusLabel);
		jPanel.validate();
		
		//jPanel.add(jLabelTwo);
		//jPanel.add(new JLabel(" "));
		//jPanel.add(new JLabel("typ hrhsgpakto, jlp kp'e w epwsp."));
		//System.out.print(decodingText);
		
		
		//get three lines
		//write a method to handle
		
		//decipher
		//write a small method to handle
		
		
		
		//make GUI
		
		
		
	}
	
	
	
	
	/**
	 * the combobox choose actionlistener
	 * would provide different categories of quotes
	 * the key would be changed
	 * and the userkey would set to alphabet
	 * 
	 * */	
	 public class MyJComboBoxListener implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	        	
	        	char selectionChar = 'b';
	            String selection = (String) myJComboBox.getSelectedItem();
	            String selectionInfo =  "Game start."; 
				statusLabel.setText(selectionInfo);
	            if (selection.equals("Computer Humor (269)")){
	            	selectionChar = 'b';
	            }
	            if (selection.equals("Computer Profound/Serious (101)")){
	            	selectionChar = 'c';
	            }
		        if (selection.equals("Fortune Cookies(69)")){
		            	selectionChar = 'f';
		        }
				if (selection.equals("Humorous (3643)")){
			         selectionChar = 'h';
			    }
				if (selection.equals("Profound/Serious (5101)")){
				        selectionChar = 'p';
				}	            
	            //tellAbout(selection);
	            currentAnswerQuote = cryptodata.getPureQuote(cryptodata.readQuotesFile(selectionChar));
	            char[] keyCharArray = cryptodata.encodeKey();
	            updateCurrentKeyChar(keyCharArray);
	            updateUserKeyChar(initialBlankUserKey.toCharArray());
	            
	            //should use gameAnswerKey and nowUserKeyChar separately
	            encodedQuote =cryptodata.encodeString(currentAnswerQuote, gameAnswerKey);
	            String displayData = cryptodata.textAreaString(encodedQuote, nowUserKeyChar);
	            myJComboBox.setEnabled(false);
				makeEncodingPanel(encodingPanel, displayData);
				decodeJText.setEnabled(true);
	        }
	    }
	
	 
	 
	/**
	 * the jtextfield listener
	 * */
	public class MyJTextFieldListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			//decodeJText.setText("123");
			String decodingText = new String(" ");
			
			decodingText = decodeJText.getText();
			int nLength = decodingText.length();
			if (nLength%2 == 1) { 
				decodingText = decodingText+" ";
				nLength = nLength+1;
			}
			String wantToReplace = decodingText.substring(0, (nLength+1)/2);
			String wantToReplaceTo = decodingText.substring((nLength+1)/2, nLength);
			//System.out.println(decodingText.substring(0,3));
			//System.out.println(decodingText.substring(3,6));
			String newKey = cryptodata.updateKey(nowUserKey, wantToReplaceTo, wantToReplace);
			//String newKey = cryptodata.replaceString(nowUserKey, "abc", "ddd");
			char[] newKeyCharArray = newKey.toCharArray();
			updateUserKeyChar(newKeyCharArray);
			//System.out.println(nowUserKey);
			
			//set the text field to blank after each guess finished
			//had better indicate his previous guess
			decodeJText.setText("");

			String displayData = cryptodata.textAreaString(encodedQuote, nowUserKeyChar);
			makeEncodingPanel(encodingPanel, displayData);
			nowDecodedQuote = cryptodata.decodeString(encodedQuote, nowUserKeyChar);
			
			System.out.println();
			
			System.out.println(nowUserKey);
			System.out.println(gameAnswerKey);
			System.out.println(nowDecodedQuote);
			System.out.println(currentAnswerQuote);
			System.out.println(cryptodata.deleteQuoteAuthor(nowDecodedQuote));
			System.out.println(cryptodata.deleteQuoteAuthor(currentAnswerQuote));
			System.out.println();
			
			if( cryptodata.deleteQuoteAuthor(nowDecodedQuote).equals(cryptodata.deleteQuoteAuthor(currentAnswerQuote))) {
				System.out.println("Congratulations!");
				JOptionPane.showMessageDialog(null, "Congratulations!", "You win!", JOptionPane.INFORMATION_MESSAGE);
			}
			//removeAll();
			//validate();
			//pack();
		}
	}
	
	
	
	

	
	/**
	 * update the user key
	 * */
	private void updateUserKeyChar(char[] newKeyCharArray) {
		nowUserKeyChar = newKeyCharArray;
		
		nowUserKey = convertToString(newKeyCharArray, "");
		
		//System.out.println("Test555 nowUserKeyChar");
		//System.out.println(nowUserKeyChar);
	}

	
	
	/**
	 * update the game key
	 * 
	 * */
	private void updateCurrentKeyChar(char[] newKeyCharArray) {
		gameAnswerKey = newKeyCharArray;
		
	}

	
	/**
	 * converts char[] to String
	 * */
	static String convertToString(char[] charArray, String separator) {
		String newString = "";
		if(charArray.length > 0) {
			
			newString = String.valueOf(charArray[0]);
			for(int i = 1; i<charArray.length && (String.valueOf(charArray[i]) != null); i++) {
			newString = newString + separator + charArray[i];
			}
		}
		return newString;
		
	}
	
	
	
	/**
	 * 
	 **/
	public class MyJTextAreaListener implements DocumentListener {
        public void insertUpdate(DocumentEvent arg0) {
            //tellAbout("JTextArea");
        	//System.out.println("test2");
        	
        }
        public void removeUpdate(DocumentEvent arg0) {
            //tellAbout("JTextArea");
        	//System.out.println("test3");
        }
        public void changedUpdate(DocumentEvent arg0) {
            //tellAbout("JTextArea");
        	//System.out.println("test4");
        }

    }
	
	public class MyNewGameActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			quitButtonConfirm = false;
			giveupButtonConfirm = false;
			statusLabel.setText("Please select quote type");
			validate();
			//currentAnswerQuote = cryptodata.readQuotesFile('p');
			//char[] keyCharArray = cryptodata.encodeKey();
	        //updateCurrentKeyChar(keyCharArray);
	        //updateUserKeyChar("abcdefghijklmnopqrstuvwxyz".toCharArray());
	        
	        //should use gameAnswerKey and nowUserKeyChar separately
	        //encodedQuote = cryptodata.encodeString(currentAnswerQuote, gameAnswerKey);
	        //String displayData = cryptodata.textAreaString(encodedQuote, nowUserKeyChar);
	        //String newGameInfo = "Please select type.";
			//makeEncodingPanel(encodingPanel, newGameInfo);
			newGame.setEnabled(false);
			giveupButton.setEnabled(true);
			myJComboBox.setEnabled(true);
		
		}
		
	}
	
	public class MyGiveUpButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//encodingPanel.removeAll();
			decodeJText.setEnabled(false);
			statusLabel.setText("Are u sure you want to give up? Press again to give up.");
			validate();
			quitButtonConfirm = false;
			if ( giveupButtonConfirm) {
				String giveupInfo = "You give up!\n" +
						"The Answer is:\n" +
						currentAnswerQuote +
						"\nPress New Game to start." +
						"\nPress Quit to quit.";
				makeEncodingPanel(encodingPanel, giveupInfo);
				statusLabel.setText("Ready.");
				validate();
				giveupButton.setEnabled(false);
				newGame.setEnabled(true);
				myJComboBox.setEnabled(false);
				quitButtonConfirm = false;
				giveupButtonConfirm = false;
			}
			
			
			giveupButtonConfirm = true;
		}
		
	}
	
	public class MyQuitButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			giveupButtonConfirm = false;
			if ( !newGame.isEnabled()) {
				String quitInfo =  "Are you sure you want to quit? Press Quit again to quit."; 
				statusLabel.setText(quitInfo);
				validate();
				
				//makeEncodingPanel(encodingPanel, quitInfo);
				//System.out.println("Are you sure you want to quit?");
				if (quitButtonConfirm) {
					dispose();
				}
				quitButtonConfirm = true;
				
			}//if(!newGame.isEnabled()) end
			else {
				quitButtonConfirm = false;
				dispose();
			}
		}
	}//end of MyQuitButtonActionListener
	
	
	
	/**
	 * hintButton class
	 * */
	public class MyHintButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			quitButtonConfirm = false;
			giveupButtonConfirm = false;
			JOptionPane.showMessageDialog(null, "x should be y", "Hint", JOptionPane.INFORMATION_MESSAGE);	
		}
	}
	
}
