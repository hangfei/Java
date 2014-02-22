package squarelotron;
import java.util.Scanner;
/**
 * The  squarelotron.
 * @author Hangfei Lin, Indira Kassymkhanova
 *
 */
abstract class Squarelotron implements SquarelotronMethods{
	/**
	 * This class contains the main method which interacts with the user, 
	 * as described above, and is the only method that does input/output. 
	 * "Anita wants you to do a program which performs the following. 
	 * It will ask you whether to use a 4x4 or a 5x5 squarelotron, 
	 * then print out the initial squarelotron (with the numbers in order, 
	 * as in (a) above; (b) is slightly jumbled). 
	 * Then the program will let you tell it which flips to perform, 
	 * and it will print out the new squarelotron after each flip. 
	 * Finally, the program will let you start with a new squarelotron, or quit."
	 * @param args
	 */
	int[][] squarelotron;
	static Scanner scanner = new Scanner(System.in);
	static int[] initial;
	static int[] linitial;
	static SmallSquarelotron slotron;
	static LargeSquarelotron llotron;
	static Squarelotron templotron;
	
	public static void main(String[] args) {
		System.out.println("Do you want to play the game? yes/no");
		String ans = scanner.nextLine();
		while (ans.equals("yes")){
			System.out.println("Which squarelotron do you want to use?");
			System.out.println("Enter 4 or 5 ");
			String line = scanner.nextLine();
			if (line.equals("4x4") || line.equals("4")) {
				initial = new int[16];
				//System.out.println("Type numbers to fill the squarelotron");
				initial = getArray(4);
			    slotron = (SmallSquarelotron) SmallSquarelotron.makeSquarelotron(initial);
			    System.out.println("The initial status is\n" + slotron);
			    templotron = slotron;
			    while(ans.equals("yes")) {
					System.out.println("Which flip do you want to perform?" +
							"\ntype: upside-down, left-right, " +
							"\ninverse-diagonal, main-diagonal, " +
							"\nrotate-right or side-flip," +
							"\notherwise type 'no' to stop");
					String flip = scanner.nextLine();
					if (flip.equals("no")) break;
					System.out.println("Which ring do you want to flip(or how many turns)?");
					String ring = scanner.nextLine();
					System.out.println("Operation = "+flip+"\nParameter=  "+ring);
					System.out.println("Flipped one is\n" + performFourFlip(flip, ring, templotron));
				}				
			}
			if (line.equals("5x5") || line.equals("5")){
				//squarelotron = new int[5][5];
				linitial = new int[25];
				//System.out.println("The numbers to fill the squarelotron");
				linitial = getArray(5);
				llotron = (LargeSquarelotron) LargeSquarelotron.makeSquarelotron(linitial);
			    System.out.println("The initial status is\n" + llotron);
			    templotron = llotron;
			    while(ans.equals("yes")) {
					System.out.println("Which flip do you want to perform?" +
							"\ntype: upside-down, left-right, " +
							"\ninverse-diagonal, main-diagonal, " +
							"\nrotate-right or side-flip," +
							" \notherwise type 'no' to stop");
					String flip = scanner.nextLine();
					if (flip.equals("no")) break;
					System.out.println("Which ring do you want to flip(or how many turns)?");
					String ring = scanner.nextLine();
					System.out.println("Operation = "+flip+"\nParameter=  "+ring);
					System.out.println("Flipped one is\n" + performFiveFlip(flip, ring, templotron));
				}	
			}
			System.out.println("Do you want to play the game again? yes/no");
			ans = scanner.nextLine();
		}
		System.out.println("You finished the game!");
		}

	
	/*
	 * return an 16 or 25 array
	 */
	private static int[] getArray(int length) throws IllegalArgumentException {
		//System.out.println("Test1  "+length);
		if (length == 5) {
			for (int i=0; i<(length*length); i++){
				//int number = scanner.nextInt();
				//System.out.println(i+"  "+length);
				
					linitial[i] = i+1;
			}
			return linitial;
		}
		else if (length ==4) {
			for (int i=0; i<(length*length); i++){
				//int number = scanner.nextInt();
				//System.out.println(i+"  "+length);
				
					initial[i] = i+1;
			}
			return initial;
		}
		else throw new IllegalArgumentException("Error!");
	}

	
	
	private static Squarelotron performFourFlip(String flip, String ring, Squarelotron inputlotron)  {
		if (flip.equals("upside-down")){
			templotron = inputlotron.upsideDownFlip(ring);
			return templotron;
		}
		else if (flip.equals("left-right")){
			templotron = inputlotron.leftRightFlip(ring);
			return templotron;
		}
		else if (flip.equals("inverse-diagonal")){
			templotron = inputlotron.inverseDiagonalFlip(ring);
			return templotron;
		}
		else if (flip.equals("main-diagonal")){
			templotron = inputlotron.mainDiagonalFlip(ring);
			return templotron;
		}
		else if (flip.equals("side-flip")){
			System.out.println("teest");
			templotron = inputlotron.sideFlip(ring);
			return templotron;
		}
		else if (flip.equals("rotate-right")){
			slotron.rotateRight(Integer.valueOf(ring));
			templotron = slotron;
			return inputlotron;
		}
		return inputlotron;
		
	}

    private static Squarelotron performFiveFlip(String flip, String ring, Squarelotron inputlotron) {
    	if (flip.equals("upside-down")){
			templotron = inputlotron.upsideDownFlip(ring);
			return templotron;
		}
		else if (flip.equals("left-right")){
			templotron = inputlotron.leftRightFlip(ring);
			return templotron;
		}
		else if (flip.equals("inverse-diagonal")){
			templotron = inputlotron.inverseDiagonalFlip(ring);
			return templotron;
		}
		else if (flip.equals("main-diagonal")){
			templotron = inputlotron.mainDiagonalFlip(ring);
			return templotron;
		}
		else if (flip.equals("side-flip")){
			templotron = inputlotron.sideFlip(ring);
			return templotron;
		}
		else if (flip.equals("rotate-right")){
			llotron.rotateRight(Integer.valueOf(ring));
			templotron = llotron;
			return inputlotron;
		}
    	return inputlotron;
    }
	
}

	
	
