package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import paint.Canvas;
import paint.CanvasToBitmap;

public class ConverterTest {
	Canvas testCanvas;
	CanvasToBitmap converter;
	
	@Before
	public void init(){
		int size = 5;
		testCanvas = new Canvas(size);
		converter = new CanvasToBitmap(testCanvas);
	}
	
	@Test
	public void testCreatesFile() {
		converter.convert("");
	}

}
