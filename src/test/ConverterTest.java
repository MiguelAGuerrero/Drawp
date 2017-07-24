package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import paint.Canvas;
import paint.Bitmap;

public class ConverterTest {
	Canvas testCanvas;
	Bitmap converter;
	
	@Before
	public void init(){
		int size = 5;
		testCanvas = new Canvas(size);
		converter = new Bitmap(testCanvas);
	}
	
	@Test
	public void testCreateFile() {
		converter.convert("out.txt");
	}

}
