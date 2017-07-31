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
		int pixelData = 0x00FF3A9C;
		Pixel testPixel = new Pixel(pixelData);
		assertEquals(testPixel.toInt(), pixelData);		
	}

}
