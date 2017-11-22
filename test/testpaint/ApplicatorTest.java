package testpaint;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import paint.Applicator;
import paint.Brush;
import paint.PixelCanvas;

public class ApplicatorTest 
{
	PixelCanvas testCanvas;
	Applicator testBrush;

	@Before
	public void initValues()
	{
		int size = 10;
		testCanvas = new PixelCanvas(size);
		testCanvas.fill(0xFFFFFF);
		testBrush = new Brush();
	}
	
	@Test
	public void testApply()
	{
		testBrush.apply(testCanvas);
		assertEquals((int) testCanvas.getPixel(0, 0), 0x0);
	}
}
