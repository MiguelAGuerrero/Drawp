package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import paint.Pixel;

public class PixelTest
{
	@Test
	public void testPixelToInt() 
	{
		int pixelData = 0xFF00FF;
		Pixel testPixel = new Pixel(pixelData);
		int pixelToInt = testPixel.toInt();
		assertEquals(pixelToInt, pixelData);		
	}
}
