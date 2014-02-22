package squarelotron;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LargeSquarelotronTest {
	LargeSquarelotron sSquarelotron;	

	@Before
	public void setUp() throws Exception {
		//fail("Not yet implemented");
		//int[][] testArray = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		
		int[] iniInput = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};		
		sSquarelotron = (LargeSquarelotron) LargeSquarelotron.makeSquarelotron(iniInput);

		//System.out.println(sSquarelotron.squarelotron[0][1]);
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
		int[][] expected = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		assertEquals(1, sSquarelotron.squarelotron[0][0]);
		assertEquals(2, sSquarelotron.squarelotron[0][1]);
		assertEquals(19, sSquarelotron.squarelotron[3][3]);
		assertArrayEquals(expected, sSquarelotron.squarelotron);
	}
	
	@Test
	public void testUpsidedownFlip() {
		Squarelotron innerlotron;
		Squarelotron outerlotron;
		int[][] expectedInner = {{1,2,3,4,5},
								{6,17,18,19,10},
								{11,12,13,14,15},
								{16,7,8,9,20},
								{21,22,23,24,25}};
		int[][] expectedOuter = {{21,22,23,24,25},
								{16,7,8,9,20},
								{11,12,13,14,15},
								{6,17,18,19,10},
								{1,2,3,4,5}};
		innerlotron = sSquarelotron.upsideDownFlip("inner");
		assertArrayEquals(expectedInner, innerlotron.squarelotron);
		
		outerlotron = sSquarelotron.upsideDownFlip("outer");
		assertArrayEquals(expectedOuter, outerlotron.squarelotron);
	}
	
	@Test
	public void testLeftRightFlip() {
		Squarelotron innerlotron;
		Squarelotron outerlotron;
		int[][] expectedInner = {{1,2,3,4,5},
								{6,9,8,7,10},
								{11,14,13,12,15},
								{16,19,18,17,20},
								{21,22,23,24,25}};
        int[][] expectedOuter = {{5,4,3,2,1},
								{10,7,8,9,6},
								{15,12,13,14,11},
								{20,17,18,19,16},
								{25,24,23,22,21}};
        innerlotron = sSquarelotron.leftRightFlip("inner");
        outerlotron = sSquarelotron.leftRightFlip("outer");
        assertArrayEquals(expectedInner, innerlotron.squarelotron);
        assertArrayEquals(expectedOuter, outerlotron.squarelotron);
	}

	@Test
	public void testRotateright() {
		int[][] expectedInner = {{21,16,11,6,1},
								{22,17,12,7,2},
								{23,18,13,8,3},
								{24,19,14,9,4},
								{25,20,15,10,5}};
		sSquarelotron.rotateRight(1);
		assertArrayEquals(expectedInner, sSquarelotron.squarelotron);
	}	
	@Test
	public void testInverseDiagonalFlip() {
		Squarelotron innerlotron;
		Squarelotron outerlotron;
		int[][] expectedInner = {{1,2,3,4,5},
								{6,19,14,9,10},
								{11,18,13,8,15},
								{16,17,12,7,20},
								{21,22,23,24,25}};
        int[][] expectedOuter = {{25,20,15,10,5},
								{24,7,8,9,4},
								{23,12,13,14,3},
								{22,17,18,19,2},
								{21,16,11,6,1}};
        innerlotron = sSquarelotron.inverseDiagonalFlip("inner");
        outerlotron = sSquarelotron.inverseDiagonalFlip("outer");
        assertArrayEquals(expectedInner, innerlotron.squarelotron);
        assertArrayEquals(expectedOuter, outerlotron.squarelotron);
	}
}