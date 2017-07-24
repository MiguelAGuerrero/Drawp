package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import paint.Canvas;

public class CanvasTest {

	/**
	 * The testCanvas
	 */
	Canvas testCanvas;
	
	/**
	 * Represents x and y values within and outside the bounds
	 * of a canvas object
	 */
	int xIn;
	int yIn;
	int xOut;
	int yOut;
	
	/**
	 * A dummy pixel
	 */
	int testPixel;
	
	@Before
	public void initValues(){
		int size = 10;
		testCanvas = new Canvas(size);
		xIn = 0;
		yIn = 0;
		xOut = testCanvas.WIDTH;
		yOut = testCanvas.HEIGHT;
		testPixel = 0x0;
	}
	
	@Test
	public void testGetPixelInBounds() {
		int pixel = 0x0;
		testCanvas.setPixel(xIn, yIn, pixel);
		assertEquals(testCanvas.getPixel(xIn, yIn), pixel);
	}
	
	@Test
	public void testGetPixelOutOfBounds(){
		int nothingReturnedValue = -1;
		assertTrue(testCanvas.getPixel(xOut, yOut) == nothingReturnedValue);
	}
	
	@Test
	public void testSetPixelInBounds() {
		assertTrue(testCanvas.setPixel(xIn, yIn, testPixel));
	}
	
	@Test
	public void testSetPixelOutOfBounds(){
		assertFalse(testCanvas.setPixel(xOut, yOut, testPixel));
	}
	
	@Test
	public void testFill(){
		testCanvas.fill(testPixel);
		for(int[] row: testCanvas.getPixels())
		{
			for(int pixel: row)
			{
				if(pixel != testPixel)
				{
					assertTrue(false);
				}
			}
		}
		
		assertTrue(true);
	}
}
