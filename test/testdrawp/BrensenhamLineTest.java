package testdrawp;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;

import org.junit.Before;
import org.junit.Test;
import drawp.BresenhamLine;

public class BrensenhamLineTest {
	BresenhamLine line = new BresenhamLine();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSlopeOfOne() {
		line.interpolate(0, 0, 5, 5);
		for(Point2D p: line.getPoints())
		{
			System.out.println(p);
		}
	}
	
	@Test
	public void testSlopeOfTwo() {
		line.interpolate(0, 0, 5, 10);
		for(Point2D p: line.getPoints())
		{
			System.out.println(p);
		}
	}

}
