package test;

import static org.junit.Assert.*;

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
		assert(testCanvas.getPixel(xIn, yIn) == pixel);
	}
	
	@Test
	public void testGetPixelOutOfBounds(){
		int nothingReturnedValue = -1;
		assert(testCanvas.getPixel(xOut, yOut) == nothingReturnedValue);
	}
	
	@Test
	public void testSetPixelInBounds() {
		assert(testCanvas.setPixel(xIn, yIn, testPixel));
	}
	
	@Test
	public void testSetPixelOutOfBounds(){
		assertFalse(testCanvas.setPixel(xOut, yOut, testPixel));
	}
}
