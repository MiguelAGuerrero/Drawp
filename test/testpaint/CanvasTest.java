package testpaint;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import paint.PixelCanvas;

public class CanvasTest 
{
	PixelCanvas testCanvas;

	/**
	 * Represents x and y values within and outside the bounds
	 * of a canvas object
	 */
	int xIn;
	int yIn;
	int xOut;
	int yOut;

	/**
	 * A dummy pixel for ad-hoc reading/writing operations for testCanvas
	 */
	int testPixel;

	@Before
	public void initValues()
	{
		int size = 10;
		testCanvas = new PixelCanvas(size);
		xIn = 0;
		yIn = 0;
		xOut = testCanvas.WIDTH;
		yOut = testCanvas.HEIGHT;
		
		//Non-zero value to preclude false-positives
		//Default int value is 0...
		testPixel = 0xFF;
	}

	@Test
	public void testGetPixelInBounds() 
	{
		int pixel = 0x0;
		testCanvas.setPixel(xIn, yIn, pixel);
		assertEquals(testCanvas.getPixel(xIn, yIn),  pixel);
	}

	@Test
	public void testGetPixelOutOfBounds()
	{
		int nothingReturnedValue = -1;
		assertTrue(testCanvas.getPixel(xOut, yOut) == nothingReturnedValue);
	}

	@Test
	public void testSetPixelInBounds()
	{
		assertTrue(testCanvas.setPixel(testPixel, xIn, yIn));
	}

	@Test
	public void testSetPixelOutOfBounds()
	{
		assertFalse(testCanvas.setPixel(testPixel, xOut, yOut));
	}

	@Test
	public void testFill()
	{
		testCanvas.fill(testPixel);
		for(int i = 0; i < testCanvas.HEIGHT; i++)
			for(int j = 0; j < testCanvas.WIDTH; j++)
				if(testCanvas.getPixel(i, j) != testPixel)
					fail();
	}
}
