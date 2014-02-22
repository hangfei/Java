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

import java.io.*;
import java.util.Arrays;

/**
 * this class would generate the data need for the game
 * and pre-process the data
 * @author Hangfei Lin
 *
 */
public class CryptogramsMaker {
	int minRange = 1;
	int maxRange = 20;
	char[] alphaBetChar = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	
	
	
/**
 * read the file
 * return a random line of a certain type"b,p etc"
 * do i need to separate this?
 * */
	public String readQuotesFile(char quoteType) {
		FileReader quotes = null;
		String s = new String();;
		//System.out.println("Test1");
		try {
			quotes = new FileReader("C:\\Users\\Varotene\\workspace\\fortunes.txt");
			//fileReader = new FileReader(quotes);
			BufferedReader bufferedReader = new BufferedReader(quotes);
			s = bufferedReader.readLine();
			//System.out.println(s);
			int randomNum;
			randomNum = minRange + (int)(Math.random() * ((maxRange - minRange) + 1));
			while((s = bufferedReader.readLine()) != null) {
				char quoteCategory = s.charAt(0);
				//System.out.println(randomNum);
				if (quoteCategory == quoteType) {
					randomNum--;
					if (randomNum == 0) {
						randomNum = minRange + (int)(Math.random() * ((maxRange - minRange) + 1));
						break;	
					}
					
				}
				
			}
			bufferedReader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	
	
	/**
	 * get the pure quote
	 * delete the type and author
	 * do we need to delete the author?
	 * */
	public String getPureQuote(String originalQuote) {
		String newString;
		newString = originalQuote.substring(2);
		return newString;
	}
	
	
	/**
	 * delete the author of each quote
	 * 
	 * */
	public String deleteQuoteAuthor(String quoteString) {
		int n = quoteString.length();
		n = quoteString.indexOf("  -- ");
		if ( n == -1 ) {n = quoteString.length();}
		char[] quoteCharArray = quoteString.toCharArray();
		String newString = "";
			for(int i=0; i < n; i++) {
				newString = newString + quoteCharArray[i];
			}
		return newString;
	}
	
	
	/**
	 * get a random mapping key
	 **/
	public char[] encodeKey() {
		int randomNum;
		randomNum = minRange + (int)(Math.random() * ((maxRange - minRange) + 1));
		String.valueOf('a');
		char[] key = new char[26];
		
		//char test;
		char encodeChar;
		//int charNum = 97;
		int tryTimes = 5;
		//int main = 0;
		boolean encodeArrayRepeat = true;
		while(encodeArrayRepeat) {
			encodeArrayRepeat = false;
			//main++;
			//System.out.println("Main Loop "+main+"  ");
			//System.out.println(key);
			int charNum = 97;
			int n = 0;
			while(n < 26) {
				//String.valueOf('a') + randomNum;
				
				//int i =0;
				boolean encodeRepeat = true;
				tryTimes = 30;
				while(encodeRepeat && tryTimes >0) {
					tryTimes--;
					//System.out.println("TryTimes= "+ tryTimes);
					
					encodeRepeat = false;
					randomNum = minRange + (int)(Math.random() * ((maxRange - minRange) + 1));
					encodeChar = (char) (charLoop(charNum ,randomNum));
					//System.out.println("charNum  "+(char)charNum+"   encodeChar= "+ encodeChar);
					for(int i = (n-1); i > -1; i--) {
						//System.out.println();
						//System.out.print(key);
						//System.out.println(key.length);
						//System.out.println(tryTimes);
						//System.out.println("key[i]=  " +key[i]+"  "+" originalChar="+(char)(charNum)+"  encodeChar=  "+encodeChar);
						if (encodeChar == key[i]) {
							encodeRepeat = true;	
							//System.out.println("Try times  " + tryTimes + "n  " + n);
							//System.out.println("en char  " +encodeChar+ "key" + key[i]);
						}
					}
					if (tryTimes == 0) {
			
						//System.out.println(n+"  encodeArrayRepeat");
						encodeArrayRepeat = true;
					}
					//else encodeArrayRepeat =false;
				}
				key[n] = (char) (charLoop(charNum ,randomNum));
				//test = (char) 6;
				n++;
				charNum++;
			}
		}

		return key;
	}

	
	
	/**
	 * update the key with several input characters
	 * you can replace only several letters
	 * return a updated string
	 * the difference from replaceCharArray is these are all char[]
	 * two parameters
	 * @param the first one is the original key
	 * @param the second one is the new key
	 * */
	public String replaceString(String originalString, String originalKeyString, String newKeyString) {
		char[] originalArray = originalString.toCharArray();
		char[] originalCharsArray = originalKeyString.toCharArray();
		char[] newKeyArray = newKeyString.toCharArray();
		char[] updatedKeys;
		updatedKeys =  replaceCharArray(originalArray, originalCharsArray, newKeyArray);
		return convertToString(updatedKeys, "");
	}

	
	/**
	 * replaceOriginal: the later part
	 * replaceNew: the previous part
	 * */
	public String updateKey(String nowKey, String replaceOriginal, String replaceNew) {
		char[] nowKeyChar = nowKey.toCharArray();
		String alphaBet = "abcdefghijklmnopqrstuvwxyz";
		char[] alphaBetChar = alphaBet.toCharArray();
		char[] replaceOriginalChar = replaceOriginal.toCharArray();
		char[] newKeyChar = nowKeyChar;
		char[] replaceNewChar = replaceNew.toCharArray();
		for(int i = 0; i < replaceOriginalChar.length; i++) {
			for(int j = 0; j < 26; j++) {
				//??? should delete?
				if(replaceOriginalChar[i] == replaceNewChar[i]) {
					if( replaceNewChar[i] == nowKeyChar[j]) {
						newKeyChar[j] = ' ';
						}
				}
				
				if( replaceOriginalChar[i] == ' ' ) {
					if( replaceNewChar[i] == nowKeyChar[j]) {
					newKeyChar[j] = ' ';
					}
				}
				//replace the key and delete the contradict ones with blanks
				if( alphaBetChar[j] == replaceOriginalChar[i] && replaceOriginalChar[i] != replaceNewChar[i]){
					if( replaceNewChar[i] != ' ') {
						newKeyChar[j] = replaceNewChar[i];
						for(int k = 0; k < 26; k++) {
							if( newKeyChar[k] == replaceNewChar[i] && k != j ) {
								newKeyChar[k] = ' ';
								//System.out.println("YEEEE"+k);
							}
							
						}
						
					}
				
					
				}
				
			}
		}
		//System.out.println("Test****");
		//System.out.println(newKeyChar);
		return convertToString(newKeyChar, "");
	}
	
	
	/**
	 * replace the string with a map
	 * return a new array
	 * helper function
	 * @param original array
	 * @param key
	 * */
	public char[] replaceCharArray(char[] originalArray, char[] newKeyArray, char[] orikeyArray) {
		char[] newcharArray = originalArray;
		int n = 0;
		int i;
		while( n < orikeyArray.length) {
			i = 0;
			while(i < originalArray.length) {
				//System.out.println(originalArray[i]);
				if(originalArray[i] == orikeyArray[n] && originalArray[i] == newcharArray[i]) {
					newcharArray[i] = newKeyArray[n];
				}
				if(originalArray[i] == (char)((int)orikeyArray[n] - ('a'-'A')) && originalArray[i] == newcharArray[i]) {
					newcharArray[i] = newKeyArray[n];
					newcharArray[i] = (char) ((int)newKeyArray[n] - ((int)'a'-(int)'A'));
				}
				i++;
			}
			n++;
		}
		return newcharArray;
	}
	
	
	
	/**
	 * encode the string with key
	 * you need to provide a whole alphabetical list of the keyArray
	 **/
	public String encodeString(String originalString, char[] keyArray) {
		//char[] key = encodeKey();
		//System.out.println(keyArray);
		//System.out.println("abcdefghijklmnopqrstuvwxyz");
		int n = 0;
		int charNum = 97;
		char[] charArray = originalString.toCharArray();
		char[] newcharArray = originalString.toCharArray();
		String newString = originalString;
		
		while(charNum < 123) {
			int i = 0;
			//System.out.println("Print");
			while(i < charArray.length) {
				if(charArray[i] == (char)charNum && charArray[i] == newcharArray[i]) {
					newcharArray[i] = keyArray[n];
				}
				//System.out.println("Print");
				
				//Error here. should be >= and <=, not > and <. has been corrected
				if( (int)charArray[i] >= (int)'A' && (int)charArray[i] <= (int)'Z') {
					if(charArray[i] == (char)(charNum-((int)'a'-(int)'A')) && charArray[i] == newcharArray[i]) {
						newcharArray[i] = (char) ((int)keyArray[n] - ((int)'a'-(int)'A'));
					}
				}
				i++;
			}
			charNum++;
			n++;
		}
		newString = new String(newcharArray);
		return newString;
	}

	/**
	 * decode the string with key
	 * if some keys are blank, the returned part would also be blank
	 * return a string
	 * make use of the encodeString method by change the keyArray
	 * 
	 * */
	public String decodeString(String encodedString, char[] keyArray) {
		//System.out.println("keyArray.length"+keyArray.length);
		//int n = 0;
		int charNum = 97;
		char[] charArray = encodedString.toCharArray();
		char[] newcharArray = new char[encodedString.length()];
		String newString = new String(encodedString);
		boolean isAlpha = false;
		//set the string to blank, then fill in the while loop
		//this guarantees that you can erase every blank key
		//cause in fact you don't know some blank key map
		for (int n = 0; n < encodedString.length(); n++, isAlpha = false) {
			for(int k = 0; k < 26; k++) {
				if(charArray[n] == (char)(97+k) || charArray[n] == (char)(97+k-('a'-'A'))) {
					isAlpha = true;
				}
			}
			if( isAlpha ) {
				newcharArray[n] = ' ';
			}
			else {
				newcharArray[n] = charArray[n];
			}
		}
		int j = 0;
		while(charNum < 123) {
			int i = 0;
			
			//loop for each characters in the encodedString
			while(i < charArray.length) {
				
				//if the key is not blank and change the string with its key
				if(keyArray[j] != ' ' && charArray[i] == keyArray[j]) {
					newcharArray[i] = (char)charNum;
				}
				
				//deal with upper case
				//Error here. should be >= and <=, not > and <. has been corrected
				if( (int)charArray[i] >= (int)'A' && (int)charArray[i] <= (int)'Z') {
					if(keyArray[j] != ' ' && charArray[i] == (char)(keyArray[j]-((int)'a'-(int)'A'))) {
						newcharArray[i] = (char) ((int)(char)charNum - ((int)'a'-(int)'A'));
					}
				}
				i++;
			}
			charNum++;
			//n++;
			
			j++;
		}
		newString = new String(newcharArray);
		//System.out.println("Tessttt888999"+newString);
		return newString;
	}
	
	
	
	/**
	 * format the string
	 * with 40 characters maximum a line
	 * maximum three lines
	 * @param original string
	 * */
	public String formatString(String originalString) {
		char[] originalArray = originalString.toCharArray();
		String[] newArray = new String[120];
		String newString;
		int n = 0;
		int m = 0;
		while(n < originalString.length()) {
				int j = 1;
			while(( (j < 20 && originalArray[n] == ' '&& n <= 40) ||
					(j < 20 && originalArray[n] == ' ' && n > 40 && n <= 80))) {
					if( n+j > originalString.length() - 1) {
						if( n+j > 40) {
							newArray[m] = " ";
							newArray[m+1] = "\n";
							m = m+2;
							n++;
						}
						break;
					}
					
					if(originalArray[n+j] == ' ') {
						if( (n+j) > 40 && n <= 40) {
							newArray[m] = " ";
							newArray[m+1] = "\n";
							m = m+2;
							n++;
							break;
						}
						if( (n+1) > 40 && (n+1) <= 80 && ((n+1)+j) > 80) {
							newArray[m] = " ";
							newArray[m+1] = "\n";
							m = m+2;
							n++;
							break;
						}
						break;
					}
					j++;
				}
			newArray[m] = String.valueOf(originalString.charAt(n));
			n++;
			m++;
			}
		newString = convertToString(newArray, "");
		return newString;
	}

	
	
	/**
	 * give a formated textArea string
	 * combine several lines(40 characters max) to one textArea.
	 * code/decode/blank....
	 * you need to provide a whole alphabetical list of the keyArray
	 * @param String originalString
	 * @param char[] keyArray
	 **/
	public String textAreaString(String originalString, char[] keyArray){
	
		String formatetOriginalString = new CryptogramsMaker().formatString(originalString);
		//System.out.println("TTTTT");
		//System.out.println(keyArray);
		String encoedeString = decodeString(originalString, keyArray);
		
		String formatedEncodedString = encoedeString;
		char[] formatetOriginalArray = formatetOriginalString.toCharArray();
		char[] foramtedEncodedArray = formatedEncodedString.toCharArray();
		StringBuffer resultString = new StringBuffer();
		
		if(formatetOriginalArray.length > 0) {
			for(int i = 0, j = 0; i < formatetOriginalArray.length; i++) {
				//if it's not \n
				if(formatetOriginalArray[i] != '\n' ) {
					resultString.append(formatetOriginalArray[i]);
				}
				//if it's \n or the end, we need to print the encoede string
				if (i == (formatetOriginalArray.length - 1)) {
					resultString.append('\n');
					for(; j < foramtedEncodedArray.length; j++) { 
						if(i <= 40) {
							if(j <= i) {
								resultString.append(foramtedEncodedArray[j]);
							}
							else {
								//add a blank line 
								resultString.append('\n');
								//end the loop, back to the i loop
								break;
							}
						}
						else {
							if(j <= i-1) {
								resultString.append(foramtedEncodedArray[j]);
							}
							else {
								//add a blank line 
								resultString.append('\n');
								//end the loop, back to the i loop
								break;
						}
						}
					}
				}
				
				if(formatetOriginalArray[i] == '\n') {
					resultString.append('\n');
					for(; j < foramtedEncodedArray.length; j++) { 
						if(i < 40) {
							if(j < i) {
								resultString.append(foramtedEncodedArray[j]);
							}
							else {
								//add a blank line 
								resultString.append('\n');
								//end the loop, back to the i loop
								break;
						}
						}
						else {
							if(j <= i-1) {
								resultString.append(foramtedEncodedArray[j]);
							}
							else {
								//add a blank line 
								resultString.append('\n');
								//end the loop, back to the i loop
								break;
						}
							
						}
					}
				}
			}
		}
		return resultString.toString();
		
	}
	
	
	
	/**
	 * judges whether the user wins
	 * 
	 * */
	public void judgeWin(String encodedString, String decodedString) {
		//TO-DO
	}
	
	
	/**
	 * convert a string array to string
	 * you can provide a string as separator or "" without separator
	 * @param stringArray
	 * @param separator
	 * had better overload with char[]
	 * */
	static String convertToString(String[] stringArray, String separator) {
		String newString = "";
		if(stringArray.length > 0) {
			newString = stringArray[0];
			for(int i = 1; i<stringArray.length && stringArray[i] != null; i++) {
			newString = newString + separator + stringArray[i];
			}
		}
		return newString;
	}
		
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
	 * return the value of the char plus a random number
	 * if it's bigger than 122, it should start from 97
	 * @warning not to big, or exceed twice
	 * @warning havn't consider this
	 * */
	public int charLoop(int numOne, int numTwo) {
		if ((numOne + numTwo) > 122) {
			//should be 96 instead of 97
			return (numOne + numTwo -122 + 96);
		}
		else return (numOne + numTwo);
	}

}
