package squarelotron;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SmallSquarelotronTest {
	SmallSquarelotron sSquarelotron;

	@Before
	public void test() {
		//fail("Not yet implemented");
		//int[][] testArray = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[] iniInput = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};		
		sSquarelotron = (SmallSquarelotron) SmallSquarelotron.makeSquarelotron(iniInput);
		assertEquals(1, sSquarelotron.squarelotron[0][0]);
		assertEquals(2, sSquarelotron.squarelotron[0][1]);
		assertEquals(16, sSquarelotron.squarelotron[3][3]);
		//System.out.println(sSquarelotron.squarelotron[0][1]);
	}
	
	@Test
	public void testNumbers() {
		//fail("Not yet implemented");
		sSquarelotron.numbers();
		assertEquals(16, sSquarelotron.slotron[15]);
		assertEquals(16, sSquarelotron.slotron[15]);
		assertEquals(1, sSquarelotron.slotron[0]);
		assertEquals(1, sSquarelotron.copylotron[0]);
		
	}
	
	@Test
	public void testUpsideDownFlip() {
		//fail("Not yet implemented");
		Squarelotron innerlotron;
		Squarelotron outerlotron;
		innerlotron = sSquarelotron.upsideDownFlip("inner");
		outerlotron = sSquarelotron.upsideDownFlip("outer");
		assertEquals(10, innerlotron.squarelotron[1][1]);
		assertEquals(8, innerlotron.squarelotron[1][3]);
		assertEquals(11, innerlotron.squarelotron[1][2]);
		assertEquals(6, innerlotron.squarelotron[2][1]);
		assertEquals(7, innerlotron.squarelotron[2][2]);
		assertEquals(1, innerlotron.squarelotron[0][0]);
		assertEquals(2, innerlotron.squarelotron[0][1]);
		assertEquals(3, innerlotron.squarelotron[0][2]);
		assertEquals(16, innerlotron.squarelotron[3][3]);
		
		assertEquals(13, outerlotron.squarelotron[0][0]);
		assertEquals(6, outerlotron.squarelotron[1][1]);
		assertEquals(7, outerlotron.squarelotron[1][2]);
		assertEquals(10, outerlotron.squarelotron[2][1]);
		assertEquals(11, outerlotron.squarelotron[2][2]);
		assertEquals(13, outerlotron.squarelotron[0][0]);
		assertEquals(14, outerlotron.squarelotron[0][1]);
		assertEquals(15, outerlotron.squarelotron[0][2]);
		assertEquals(4, outerlotron.squarelotron[3][3]);		
	}

	@Test
	public void testLeftRightFlip() {
		//fail("Not yet implemented");
		Squarelotron innerlotron;
		Squarelotron outerlotron;
		innerlotron = sSquarelotron.leftRightFlip("inner");
		outerlotron = sSquarelotron.leftRightFlip("outer");
		assertEquals(1, innerlotron.squarelotron[0][0]);
		assertEquals(2, innerlotron.squarelotron[0][1]);
		assertEquals(7, innerlotron.squarelotron[1][1]);
		assertEquals(6, innerlotron.squarelotron[1][2]);
		assertEquals(11, innerlotron.squarelotron[2][1]);
		assertEquals(10, innerlotron.squarelotron[2][2]);
		assertEquals(1, innerlotron.squarelotron[0][0]);
		assertEquals(2, innerlotron.squarelotron[0][1]);
		assertEquals(3, innerlotron.squarelotron[0][2]);
		assertEquals(13, innerlotron.squarelotron[3][0]);
		assertEquals(14, innerlotron.squarelotron[3][1]);
		assertEquals(15, innerlotron.squarelotron[3][2]);
		assertEquals(16, innerlotron.squarelotron[3][3]);
		
		assertEquals(4, outerlotron.squarelotron[0][0]);
		assertEquals(3, outerlotron.squarelotron[0][1]);
		assertEquals(2, outerlotron.squarelotron[0][2]);
		assertEquals(1, outerlotron.squarelotron[0][3]);
		assertEquals(8, outerlotron.squarelotron[1][0]);
		assertEquals(6, outerlotron.squarelotron[1][1]);
		assertEquals(7, outerlotron.squarelotron[1][2]);
		assertEquals(5, outerlotron.squarelotron[1][3]);
		assertEquals(12, outerlotron.squarelotron[2][0]);
		assertEquals(10, outerlotron.squarelotron[2][1]);
		assertEquals(11, outerlotron.squarelotron[2][2]);
		assertEquals(9, outerlotron.squarelotron[2][3]);
		assertEquals(16, outerlotron.squarelotron[3][0]);
		assertEquals(15, outerlotron.squarelotron[3][1]);
		assertEquals(14, outerlotron.squarelotron[3][2]);
		assertEquals(13, outerlotron.squarelotron[3][3]);
		
	}
	
	@Test
	public void testInverseDiagonalFlip() {
		Squarelotron innerlotron;
		innerlotron = sSquarelotron.inverseDiagonalFlip("inner");
		Squarelotron outerlotron;
		outerlotron = sSquarelotron.inverseDiagonalFlip("outer");
		//Squarelotron outerlotron;
		assertEquals(1, innerlotron.squarelotron[0][0]);
		assertEquals(2, innerlotron.squarelotron[0][1]);
		assertEquals(3, innerlotron.squarelotron[0][2]);
		assertEquals(4, innerlotron.squarelotron[0][3]);
		assertEquals(5, innerlotron.squarelotron[1][0]);
		assertEquals(11, innerlotron.squarelotron[1][1]);
		assertEquals(7, innerlotron.squarelotron[1][2]);
		assertEquals(8, innerlotron.squarelotron[1][3]);
		assertEquals(9, innerlotron.squarelotron[2][0]);
		assertEquals(10, innerlotron.squarelotron[2][1]);
		assertEquals(6, innerlotron.squarelotron[2][2]);
		assertEquals(12, innerlotron.squarelotron[2][3]);
		assertEquals(13, innerlotron.squarelotron[3][0]);
		assertEquals(14, innerlotron.squarelotron[3][1]);
		assertEquals(15, innerlotron.squarelotron[3][2]);
		assertEquals(16, innerlotron.squarelotron[3][3]);

		assertEquals(16, outerlotron.squarelotron[0][0]);
		assertEquals(12, outerlotron.squarelotron[0][1]);
		assertEquals(8, outerlotron.squarelotron[0][2]);
		assertEquals(4, outerlotron.squarelotron[0][3]);
		assertEquals(15, outerlotron.squarelotron[1][0]);
		assertEquals(6, outerlotron.squarelotron[1][1]);
		assertEquals(7, outerlotron.squarelotron[1][2]);
		assertEquals(3, outerlotron.squarelotron[1][3]);
		assertEquals(14, outerlotron.squarelotron[2][0]);
		assertEquals(10, outerlotron.squarelotron[2][1]);
		assertEquals(11, outerlotron.squarelotron[2][2]);
		assertEquals(2, outerlotron.squarelotron[2][3]);
		assertEquals(13, outerlotron.squarelotron[3][0]);
		assertEquals(9, outerlotron.squarelotron[3][1]);
		assertEquals(5, outerlotron.squarelotron[3][2]);
		assertEquals(1, outerlotron.squarelotron[3][3]);

	}
	
	@Test
	public void testMainDiagonalFlip() {
		Squarelotron innerlotron;
		innerlotron = sSquarelotron.mainDiagonalFlip("inner");
		Squarelotron outerlotron;
		outerlotron = sSquarelotron.mainDiagonalFlip("outer");
		//Squarelotron outerlotron;
		assertEquals(1, innerlotron.squarelotron[0][0]);
		assertEquals(2, innerlotron.squarelotron[0][1]);
		assertEquals(3, innerlotron.squarelotron[0][2]);
		assertEquals(4, innerlotron.squarelotron[0][3]);
		assertEquals(5, innerlotron.squarelotron[1][0]);
		assertEquals(6, innerlotron.squarelotron[1][1]);
		assertEquals(10, innerlotron.squarelotron[1][2]);
		assertEquals(8, innerlotron.squarelotron[1][3]);
		assertEquals(9, innerlotron.squarelotron[2][0]);
		assertEquals(7, innerlotron.squarelotron[2][1]);
		assertEquals(11, innerlotron.squarelotron[2][2]);
		assertEquals(12, innerlotron.squarelotron[2][3]);
		assertEquals(13, innerlotron.squarelotron[3][0]);
		assertEquals(14, innerlotron.squarelotron[3][1]);
		assertEquals(15, innerlotron.squarelotron[3][2]);
		assertEquals(16, innerlotron.squarelotron[3][3]);

		assertEquals(1, outerlotron.squarelotron[0][0]);
		assertEquals(5, outerlotron.squarelotron[0][1]);
		assertEquals(9, outerlotron.squarelotron[0][2]);
		assertEquals(13, outerlotron.squarelotron[0][3]);	
	}

	@Test
	public void testsideFlip() {
		Squarelotron leftlotron;
		leftlotron = sSquarelotron.sideFlip("left");
		Squarelotron rightlotron;
		rightlotron = sSquarelotron.sideFlip("right");
		assertEquals(2, leftlotron.squarelotron[0][0]);
		assertEquals(1, leftlotron.squarelotron[0][1]);
		assertEquals(3, leftlotron.squarelotron[0][2]);
		assertEquals(4, leftlotron.squarelotron[0][3]);
		assertEquals(6, leftlotron.squarelotron[1][0]);
		assertEquals(5, leftlotron.squarelotron[1][1]);		
		
		assertEquals(5, rightlotron.squarelotron[1][0]);
		assertEquals(6, rightlotron.squarelotron[1][1]);
		assertEquals(8, rightlotron.squarelotron[1][2]);
		assertEquals(7, rightlotron.squarelotron[1][3]);
		//assertEquals(9, rightlotron.squarelotron[2][0]);
		//assertEquals(7, rightlotron.squarelotron[2][1]);
		//assertEquals(11, rightlotron.squarelotron[2][2]);
		//assertEquals(12, rightlotron.squarelotron[2][3]);
		//assertEquals(13, rightlotron.squarelotron[3][0]);
		//assertEquals(14, rightlotron.squarelotron[3][1]);
		//assertEquals(15, rightlotron.squarelotron[3][2]);
		//assertEquals(16, rightlotron.squarelotron[3][3]);
	}
	
	@Test
	public void testRotateright() {
		int[][] expectedInner = {{13,9,5,1},
								{14,10,6,2},
								{15,11,7,3},
								{16,12,8,4}};
		sSquarelotron.rotateRight(1);
		assertArrayEquals(expectedInner, sSquarelotron.squarelotron);
	}	
	
	@Test
	public void testEquals() {
		SmallSquarelotron that;
		int[] thatInput = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}; 
		that = (SmallSquarelotron) SmallSquarelotron.makeSquarelotron(thatInput);
		assertTrue(sSquarelotron.equals(that));
		
		SmallSquarelotron that2;
		int[] that2Input = {2,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}; 
		that2 = (SmallSquarelotron) SmallSquarelotron.makeSquarelotron(that2Input);
		assertFalse(sSquarelotron.equals(that2));
	}
	
	@Test
	public void testTostring() {
		//System.out.println(sSquarelotron);
	}

}