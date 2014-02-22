package pig;

import java.util.Scanner;

/**
 * a class to represent the human
 * this class extends player
 * inlude two new mehtods
 * @author Varotene
 * @verstion 1.0
 */
public class Human extends Player {
	
	boolean rollChoice = true;
	int rollDie = 0;
	int scoreGain = 0;
	int totalScore = 0;
	/**
	 * to roll the die some number of times 
	 * and keep score
	 */
	void takeTurn() {
		while(rollChoice == true) {			
			rollDie = rollDie();
			//System.out.print(score+"  " + scoreGain+"rollDie"+rollDie);
			System.out.print("You rolled " + rollDie + ".\n");
			if (rollDie == 1) {
				scoreGain = 0;
				System.out.print("You have to stop.\n");
				break;
			}
			scoreGain = scoreGain + rollDie;
			totalScore = score + scoreGain;
			System.out.print("Your score is now: " + totalScore);
			System.out.print("\n");
			
			rollChoice = askUser("Do you want to continue?\n");
            if (rollChoice == false) {
            	System.out.print("The player choose to stop.\n");
            }
		}
		score = score + scoreGain;
		rollChoice = true;
		scoreGain = 0;
		totalScore = 0;
	}
	
	/**to print this player's score
	 * 
	 */
	void printScore() {
		System.out.print("Your score is now:" + score);
	}

	/**
	 * to ask whether the user want to continue
	 * @param question
	 * @return
	 */
	static boolean askUser(String question) {
		Scanner scanner = new Scanner(System.in);
		char answer = ' ';
		while (answer != 'y' && answer != 'n') {
			System.out.print(question + " ");
			String line = scanner.nextLine();
			if (line.length() == 0) continue;
			answer = Character.toLowerCase(line.charAt(0));
		}
		return answer == 'y';
	}
	

}
