package test;

import stats.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class StatsTest {

	@Test
	public void testMean() {
		
		int[] array = {5,8,4,6,3,2,7,8,2};
		
		assertEquals(5, Stats.getMean(array), 0);		 
	}
	
	@Test
	public void testMedian() {
		
		int[] array = {5,8,4,6,3,2,7,8,2}; 
		
		assertEquals(5, Stats.getMedian(array), 0);
	}
	
	
	@Test
	public void testMode() {
		int[] array = {5,8,4,6,3,2,7,8,2,3,10,10,4,2};
		
		assertEquals(2, Stats.getMode(array), 0);
	}
	
	@Test
	public void testRange() {
		int[] array = {5,8,4,6,3,2,7,8,2};
		
		assertEquals(6, Stats.testRange(array));
	}
	
	@Test
	public void testVariance() {
		int[] array = {5,8,4,6,3,2,7,8,2};
		
		assertEquals(5, Stats.testVariance(array));
	}
	
	@Test
	public void testStdDev() {
		
		int[] array = {5,8,4,6,3,2,7,8,2};
		
		assertEquals(2, Stats.testStdDev(array));
		
	}
	
	@Test
	public void testIQR() {
		
		int[] array = {-30 , -1, 0, 3, 7, 8, 10, 12, 16, 20, 25, 27, 28, 32, 60};
		
		Stats.testIQR(array);
		
		assertEquals(24, Stats.getIqr(), 0);
		assertEquals(-33, Stats.getQ1(), 0);
		assertEquals(63, Stats.getQ3(), 0);
		
	}

}
