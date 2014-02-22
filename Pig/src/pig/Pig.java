package pig;



/**
 * the main class and the main method
 * @author Varotene
 * @verstion 1.0
 */
public class Pig {	
	Computer computer = new Computer();
	Human human = new Human();
	
	/**
	 * the main method
	 * @param args
	 */
	public static void main(String[] args) {
		new Pig().playGame();
	}
	
	/**
	 * to judge who wins the game
	 * return true if someone win
	 * else return false
	 * @return
	 */
	public boolean whoWin() {
		if (computer.getScore() >= 100 && human.getScore() < 100) {
			System.out.print("The computer has won!");
			return true;
		}
		
	    if (human.getScore() >= 100 && computer.getScore() < 100) {
	    	System.out.print("You win!");
	    	return true;	
	    }
	    
	    if (human.getScore() >= 100 && computer.getScore() > 100) {
	    	if (human.getScore() > computer.getScore()) {
	    		System.out.print("You win!");
	    		return true;
	    	}
	    	
	    	if (human.getScore() < computer.getScore()) {
	    		System.out.print("The computer has won!");
	    		return true;
	    	}
	    	
	    	if (human.getScore() == computer.getScore()) {
	    		System.out.print("You are equal!");
	    		return true;
	    	}
	    }
	    return false;
	}
	
	/**
	 * the main control of the  game process
	 */
	void playGame() {
		//tell the user game begin
		System.out.print("Game start!");
		System.out.print('\n');
		while (!whoWin()) {
			System.out.print("\n");
			//computer( no loop, just a random number)
			computer.takeTurn();			
			computer.printScore();
			System.out.print('\n');			
            
			//human
			human.takeTurn();
			human.printScore();
			System.out.print('\n');
			//judge
			if (whoWin()) {
				return;
			}

		}
	}
}
