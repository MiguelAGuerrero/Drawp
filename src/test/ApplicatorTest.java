package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import paint.Applicator;
import paint.Canvas;
import paint.PointBrush;

public class ApplicatorTest 
{
	Canvas testCanvas;
	Applicator<Integer> testBrush;

	@Before
	public void initValues()
	{
		int size = 10;
		testCanvas = new Canvas(size);
		testCanvas.fill(0xFFFFFF);
		testBrush = new PointBrush();
	}
	
	@Test
	public void testApply()
	{
		testBrush.apply(testCanvas);
		assertEquals((int) testCanvas.getPixel(0, 0), 0x0);
	}
}
