package squarelotron;

import java.util.Arrays;


/**
 * The  large(4x4) squarelotron.
 * @author Handfei Lin, Indira Kassymkhanova
 *
 */
public class SmallSquarelotron extends Squarelotron implements SquarelotronMethods{
	int[] slotron = new int[16];
	int[] copylotron = new int[16];
	int slength =4;
	/**
	 * These are the constructors for squarelotrons. 
	 * Given an int[] of the correct size (either 16 or 25 numbers), initializes a squarelotron.
	 * @param array
	 */
	private SmallSquarelotron(int[] array) {
		// TODO Auto-generated constructor stub
		squarelotron = to2D(array);
	}
	
	/**
	 * Creates a 2D matrix from 1D array
	 * @param array
	 * @return
	 */
	private int[][] to2D(int[] array) {
		int[][] array2D = new int[4][4];
		int n = 0; 
		for(int i=0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				array2D[i][j] = array[n];
				n++;
			}
		}
		return array2D;
	}
	
	/**
	 * Constructs and returns a squarelotron if the following conditions are met: 
	 * (1) The given array is either 16 or 25 in length
	 * (2) all the numbers in the array are nonnegative (zero is allowed) and less than or equal to 99.
	 */
	public static Squarelotron makeSquarelotron (int[] array) throws IllegalArgumentException{
		if (array.length!=16 && array.length !=25){
			throw new IllegalArgumentException("It is not 4x4 or 5x5");
		}
		for (int i=0; i<array.length; i++){
			if (array[i]<0 || array[i]>99){
				throw new IllegalArgumentException("Numbers must be non-negative! and <= 99!");
			}
		}
		SmallSquarelotron smalltron = new SmallSquarelotron(array);
		return smalltron;
		
	}
	
	/**
	 * transform the squarelotron to 1D array 
	 * @return
	 */
	public int[] numbers(){
		int k = 0;
		for (int i = 0; i< slength; i++){
			for (int j = 0; j<slength; j++){
				slotron[k] = squarelotron[i][j];
				copylotron[k] = squarelotron[i][j];
				k++;
			}
		}	
		return slotron;
	}
	
	/**
	 * This method performs the Upside-Down Flip of the squarelotron
	 * @param ring
	 * @return
	 */
	public Squarelotron upsideDownFlip(String ring){
		if (ring.equals("outer")) {
			int k = 0;
			for (int i = 0; i < slength; i++){
				for (int j = 0; j<slength; j++){
					if (i<3 && i>0 && j<3 && j>0){
						copylotron[k] = squarelotron[i][j];
					}
					else copylotron[k] = squarelotron[Math.abs(i-3)][j];
					k++;
				}
			}
		}
		if (ring.equals("inner")) {
			int k = 0;
			for (int i = 0; i < slength; i++){
				for (int j = 0; j<slength; j++){
					if (i<3 && i>0 && j<3 && j>0){
						copylotron[k] = squarelotron[Math.abs(i-3)][j];
					}
					else {
						copylotron[k] = squarelotron[i][j];			
					}
					k++;		
				}
			}
		}
		SmallSquarelotron flipSquarelotron = new SmallSquarelotron(copylotron);
		return flipSquarelotron;
	}
	
	/**
	 * This method performs the Left-Right Flip of the squarelotron
	 * @param ring
	 * @return
	 */
	public Squarelotron leftRightFlip(String ring){
		if (ring.equals("outer")){
			int k = 0;
			for (int i = 0; i < slength; i++){
				for (int j = 0; j<slength; j++){
					if  (i<3 && i>0 && j<3 && j>0){
						copylotron[k] = squarelotron[i][j];
					}
					else copylotron[k] = squarelotron[i][Math.abs(j-3)];
					k++;
				}
			}
		}
		else if (ring.equals("inner")) {
			int k = 0;
			for (int i = 0; i < slength; i++){
				for (int j = 0; j<slength; j++){
					if  (i<3 && i>0 && j<3 && j>0){
						copylotron[k] = squarelotron[i][Math.abs(j-3)];
					}
					else copylotron[k] = squarelotron[i][j];
					k++;	
				}
			}
		}
		SmallSquarelotron flipSquarelotron = new SmallSquarelotron(copylotron);
		return flipSquarelotron;
	}
	
	/**
	 * This method performs the Main Inverse Diagonal of the squarelotron
	 * opposite to ordinary diagonal
	 * @param ring
	 * @return
	 */
	public Squarelotron inverseDiagonalFlip(String ring){
		if (ring.equals("outer")){
			int k = 0;
			for (int i = 0; i < 4; i++){
				for (int j = 0; j<4; j++){
					if (i<3 && i>0 && j<3 && j>0){
						copylotron[k] = squarelotron[i][j];
					}
					else copylotron[k] = squarelotron[3-j][3-i];
					k++;
				}
			}
		}
		else if (ring.equals("inner")){
			int k = 0;
			for (int i = 0; i < 4; i++){
				for (int j = 0; j<4; j++){
					if (i<3 && i>0 && j<3 && j>0){
						copylotron[k] = squarelotron[3-j][3-i];
					}
					else copylotron[k] = squarelotron[i][j];
					k++;
				}
			}
		}
		SmallSquarelotron flipSquarelotron = new SmallSquarelotron(copylotron);
		return flipSquarelotron; 
	}
	
	/**
	 * This method performs the Main Diagonal Flip of the squarelotron
	 * @param ring
	 * @return
	 */
	public Squarelotron mainDiagonalFlip(String ring){
		if (ring.equals("outer")){
			int k = 0;
			for (int i = 0; i < 4; i++){
				for (int j = 0; j<4; j++){
					if (i<3 && i>0 && j<3 && j>0){
						copylotron[k] = squarelotron[i][j];
					}
					else copylotron[k] = squarelotron[j][i];
					k++;
				}
			}
		}
		else if (ring.equals("inner")){
			int k = 0;
			for (int i = 0; i < 4; i++){
				for (int j = 0; j<4; j++){
					if (i<3 && i>0 && j<3 && j>0){
						copylotron[k] = squarelotron[j][i];
					}
					else copylotron[k] = squarelotron[i][j];
					k++;
				}
			}
		}
		SmallSquarelotron flipSquarelotron = new SmallSquarelotron(copylotron);
		return flipSquarelotron;
	}
	
	/**
	 * The argument side should be one of the four strings "left", "right", "top", and "bottom". 
	 * The two indicated columns (leftmost or rightmost), or the two indicated rows 
	 * (top two rows or bottom two rows) should be interchanged. 
	 */
	public Squarelotron sideFlip(String ring){
		    int k = 0;
			for (int i = 0; i < 4; i++){
				for (int j = 0; j<4; j++){
					copylotron[k] = squarelotron[i][j];
					//System.out.println("squarelotron[i][j]="+squarelotron[i][j]);
					//System.out.println(j);
					if ((i==0 && ring.equals("top")) || (i==2 && ring.equals("bottom"))){
						copylotron[k] = squarelotron[i+1][j];
						//System.out.println("test3");
						
					}
					if ( (i==1 && ring.equals("top")) || (i==3 && ring.equals("bottom"))){
						copylotron[k] = squarelotron[i-1][j];
						//System.out.println("test2");
												
					}
					if ((j==2 && ring.equals("right")) || (j==0 && ring.equals("left"))){
						copylotron[k] = squarelotron[i][j+1];
						System.out.println("test");
						
					}
					if ((j==3 && ring.equals("right"))|| (j==1 && ring.equals("left"))){
						copylotron[k] = squarelotron[i][j-1];
						System.out.println("test88");
					}
					//one bug here, "else" only belongs to the last one
					//System.out.println("test4  " + k +"__"+copylotron[k]);
					//System.out.println();
					k++;
				}
				
			}
			//System.out.println("0="+copylotron[0]+"  01="+copylotron[3]);
			SmallSquarelotron flipSquarelotron = new SmallSquarelotron(copylotron);
			return flipSquarelotron;
		}
	
	/**
	 * The argument numberOfTurns indicates the number of times the squarelotron 
	 * should be rotated 90 Any integer, including zero and negative integers, 
	 * is allowable as the second argument. A value of -1 indicates a 90 
	 */
	public void rotateRight(int numberOfTurns){
		
		int n = numberOfTurns;
		int[][] temp = squarelotron;
		if ((Math.abs(numberOfTurns) % 4 == 0 && numberOfTurns > 0) ){
			n = 0;
		}
		else if (( ((numberOfTurns%4) == 1)  && numberOfTurns > 0)|| (((Math.abs(numberOfTurns)%4) == 3)  && numberOfTurns < 0)){
			n = 1;
		}
		else if (( ((numberOfTurns%4) == 2)  && numberOfTurns > 0)|| (((Math.abs(numberOfTurns)%4) == 2)  && numberOfTurns < 0)){
			n = 2;
		}
		else if (( ((numberOfTurns%4) == 3)  && numberOfTurns > 0)|| (((Math.abs(numberOfTurns)%4) == 1)  && numberOfTurns < 0)){
			n = 3;
		}
		
		while (n > 0) {
			int k = 0;
			int z = 0;
			for (int i = 0; i < slength; i++){
				for (int j = 0; j < slength; j++) {
					copylotron[k] = temp[slength-1-j][z];
					k++;
				}
				z++;
			}
			temp = to2D(copylotron);
			n--;
		}
		squarelotron = temp;
	}
	
	
	/**
	 * Returns true if the object is a squarelotron that is equal to this squarelotron, 
	 * and false otherwise. 
	 * Squarelotrons that are the same except for rotations are considered equal. 
	 * Squarelotrons of different sizes are never equal. 
	 */
	@Override
	public boolean equals(Object object) {
		
		if (! (object instanceof Squarelotron)) {
			return false;
		}
		Squarelotron that = (Squarelotron) object;
        return Arrays.deepEquals(this.squarelotron,  that.squarelotron);
		
	}

	/**
     * return the squarelotron
     * override the toString method
     * 
     */
	@Override
	public String toString(){
		String tostring = "";
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				if (squarelotron[i][j] > 9) {
					tostring = tostring + Integer.toString(squarelotron[i][j])+"  ";
				}
				else {
					tostring = tostring + Integer.toString(squarelotron[i][j])+"   ";
				}
				 
			}
			tostring = tostring + "\n";
		}
		return tostring;
	}
}