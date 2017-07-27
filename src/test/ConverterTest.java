package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import paint.Canvas;
import paint.Converter;

public class ConverterTest
{
	Canvas testCanvas;
	Converter converter;
	
	@Before
	public void init()
	{
		int size = 1000;
		testCanvas = new Canvas(size);
		converter = new Converter(testCanvas);
	}
	
	@Test
	public void testCreateFile()
	{
		testCanvas.fill(0x0000FF);
		String output = "out.bmp";
		assertTrue(converter.convert(output));
	}
}
