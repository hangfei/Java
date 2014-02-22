package magic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MagicSquareTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
		MagicSquare sq = new MagicSquare(5);
		MagicSquare sqThree = new MagicSquare(3);
		//MagicSquare sq9 = new MagicSquare(9);
		int[][] expected= {{17,24,1,8,15},
							{23,5,7,14,16},
							{4,6,13,20,22},
							{10,12,19,21,3},
							{11,18,25,2,9}}; 
		int[][] expectedThree = {{8,1,6},
							{3,5,7},
							{4,9,2}};
		//sqArray = sq.getMagicSquareArray();
		//System.out.println(sqThree);
		//System.out.println(sq9);
		assertEquals(1, sq.getMagicSquareArray()[0][2]);
		assertEquals(2, sq.getMagicSquareArray()[4][3]);
		assertEquals(3, sq.getMagicSquareArray()[3][4]);
		assertEquals(4, sq.getMagicSquareArray()[2][0]);
		assertEquals(5, sq.getMagicSquareArray()[1][1]);
		assertArrayEquals(expected, sq.getMagicSquareArray());
		assertArrayEquals(expectedThree, sqThree.getMagicSquareArray());
		
		
	}

}
