package pig;

import java.util.Random;

/**
 * a class to represent the human
 * this class extends player
 * inlude two new mehtods
 * @author Varotene
 * @verstion 1.0
 */
public class Computer extends Player {
	static Random random = new Random();
	
	
	/**
	 * to roll the die some number of times 
	 * and keep score
	 */
	void takeTurn() {
		int rollDie = 0;
		int scoreGain = 0;
		int rollChoice = 1;
		while( rollChoice == 1) {
			rollDie = rollDie();
			System.out.print("The computer rolls " + rollDie + ".\n");
			if (rollDie == 1) {
				scoreGain = 0;
				System.out.print("He has to stop.\n");
				break;
			}
			scoreGain = scoreGain + rollDie;
			rollChoice = random.nextInt(2);	
			if (rollChoice == 0) {
				System.out.print("The computer choose to stop.\n");
			}
		}
		score = score + scoreGain;
		scoreGain = 0;
		rollDie = 0;
		rollChoice = 1;	
	}
	
	/**to print this player's score
	 * 
	 */
	void printScore() {
		System.out.print("The computer's score now is:" + score);
	}
	

}
