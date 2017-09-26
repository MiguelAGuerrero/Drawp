package testpaint;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import paint.Canvas;

public class CanvasTest 
{
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
	 * A dummy pixel for ad-hoc reading/writing operations for testCanvas
	 */
	int testPixel;

	@Before
	public void initValues()
	{
		int size = 10;
		testCanvas = new Canvas(size);
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
		assertEquals(testCanvas.getPixel(xIn, yIn), (Integer) pixel);
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
		assertTrue(testCanvas.setPixel(xIn, yIn, testPixel));
	}

	@Test
	public void testSetPixelOutOfBounds()
	{
		assertFalse(testCanvas.setPixel(xOut, yOut, testPixel));
	}

	@Test
	public void testFill()
	{
		testCanvas.fill(testPixel);
		for(Integer pixel: testCanvas)
		{
			if(pixel != testPixel)
			{
				fail();
			}
		}
	}
}
