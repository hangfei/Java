package pig;

import java.util.Random;

/**
 * the class would be inherited by Computer and Human class
 * @author Varotene
 *
 */
public class Player {
	protected int score;
	static Random random = new Random();
	
	/**
	 * constructor, set score to 0
	 */
	Player() {
		score = 0;
	}
	
	/**
	 * return the score
	 * @return
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * return a random number between 1-6
	 * @return
	 */
	public int rollDie() {
		return random.nextInt(6) + 1;
		
	}

}
