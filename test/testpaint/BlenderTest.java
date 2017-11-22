package testpaint;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import paint.BlendType;
import paint.Blender;
import paint.Pixel;

public class BlenderTest
{
	private Blender<Integer> testBlender;
	private Pixel p1;
	private Pixel p2;
	
	@Before
	public void setUp() throws Exception {
		p1 = new Pixel(100, 100, 100, 255);
		p2 = new Pixel(50, 50, 50, 255);
	}

	@Test
	public void testAdd() {
		testBlender = BlendType.ADD;
		System.out.println(testBlender.blend(p1.toInt(), p2.toInt()));
		
		Pixel expectedPixel = new Pixel(150, 150, 150, 255);
		//assertTrue(p3.equals(expectedPixel));
	}

}
