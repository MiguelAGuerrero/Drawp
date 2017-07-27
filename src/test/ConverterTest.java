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
		int size = 5;
		testCanvas = new Canvas(size);
		converter = new Converter(testCanvas);
	}
	
	@Test
	public void testCreateFile()
	{
		testCanvas.fill(0x0000FF);
		String output = "out.txt";
		assertTrue(converter.convert(output));
	}
}
