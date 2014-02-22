/**
 * 
 */
package magic;


/**
 * This class would generate a odd dimension of magic square
 * the dimension of the magic square is the parameters
 * constructor
 * getMagicSquareArray
 * @author Varotene
 *
 */
public class MagicSquare {
	private int[][] magicSquare;
	int squareSize;
	
	/**
	 * initialize the magicsquare and its size
	 * 
	 **/
	public MagicSquare(int size) {
		int n = 1;
		squareSize = size;
		magicSquare = new int[size][size];
		for(int i = 0, j = (size-1)/2; n <= size*size; j++, i--) {
			if (magicSquare[(size-Math.abs(i)%size)%size][Math.abs(j)%size] != 0) {
				magicSquare[(size-Math.abs(i+2)%size)%size][Math.abs(j-1)%size] = n;
				i = i+2;
				j = j-1;
			}
			else {
			    magicSquare[(size-Math.abs(i)%size)%size][Math.abs(j)%size] = n;
			}
			n++;
		}
	}
	
	/**
	 * return the magicsquare matrix
	 * 
	 **/
	public int[][] getMagicSquareArray() {
		return magicSquare;
	}
	
	
	/**
	 * return the magicsquare size
	 * 
	 **/
	public int getSquareSize() {
		return squareSize;
	}
	
	
	
	/**
	 * override the toString method
	 * 
	 * */
	@Override
	public String toString(){
		String tostring = "";
		for (int i=0; i<squareSize; i++) {
			for (int j=0; j<squareSize; j++) {
				if (magicSquare[i][j] > 9) {
					tostring = tostring + Integer.toString(magicSquare[i][j])+"  ";
				}
				else {
					tostring = tostring + Integer.toString(magicSquare[i][j])+"   ";
				}
				 
			}
			tostring = tostring + "\n";
		}
		return tostring;
	}
}

