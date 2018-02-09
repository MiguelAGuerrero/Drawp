package testpaint;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import paint.Applicator;
import paint.BlendType;
import paint.Brush;
import paint.PaintCanvas;

public class BrushTest 
{
	PaintCanvas testCanvas;
	Brush testBrush;

	@Before
	public void initValues()
	{
		int size = 10;
		testCanvas = new PaintCanvas(size);
		testCanvas.fill(0xFFFFFF);
		testBrush = new Brush();
	}
	
	@Test
	public void testApplicationWithNoBlend()
	{
		testBrush.apply(testCanvas);
		int pixel = testCanvas.getPixel(0,  0);
		System.out.println(Integer.toHexString(pixel));
		assertEquals((int) testCanvas.getPixel(0, 0), 0x0);
	}
}
