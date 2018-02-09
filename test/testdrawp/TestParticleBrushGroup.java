package testdrawp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import drawp.ParticleBrush;
import drawp.CompositeParticleBrush;

public class TestParticleBrushGroup
{

	CompositeParticleBrush testCBG;
	ParticleBrush testParticleBrushes;
	double epsilon = 0.000001;
	
	@Before
	public void setUp() throws Exception
	{
		testCBG = new CompositeParticleBrush();
		int arbitrary = 3;
		for(int i = 0; i < arbitrary; i++)
		{
			testCBG.addBrush(new ParticleBrush());
		}
	}
	
	@Test
	public void testComposingBrushMovesWithCenterBrush()
	{
		testCBG.setVelocityX(1);
		testCBG.move();
		for(ParticleBrush pb: testCBG)
		{
			assertTrue(pb.getX() != 0);
		}
	}
	
	@Test
	public void testComposingBrushesMove1PixXWithCenterBrush()
	{
		testCBG.setVelocityX(1);
		testCBG.move();
		for(ParticleBrush pb: testCBG)
		{
			assertEquals(pb.getX(), 1, epsilon);
		}
	}
	
	@Test
	public void testComposingBrushesMove2PixXWithCenterBrush()
	{
		testCBG.setVelocityX(1);
		testCBG.move();
		testCBG.move();
		for(ParticleBrush pb: testCBG)
		{
			assertEquals(pb.getX(), 2, epsilon);
		}
	}
	
	@Test
	public void testComposingBrushesMove1PixYWithCenterBrush()
	{
		testCBG.setVelocityY(1);
		testCBG.move();
		for(ParticleBrush pb: testCBG)
		{
			assertEquals(pb.getY(), 1, epsilon);
		}
	}
	
	@Test
	public void testComposingBrushesMove2PixYWithCenterBrush()
	{
		testCBG.setVelocityY(1);
		testCBG.move();
		testCBG.move();
		for(ParticleBrush pb: testCBG)
		{
			assertEquals(pb.getY(), 2, epsilon);
		}
	}
	
	@Test
	public void testWhetherComposingBrushesKineticsYAreMaintainedWhenMovingWithCenterBrush()
	{
		testCBG.setVelocityX(1);
		for(ParticleBrush pb: testCBG)
		{
			pb.setVelocity(0, 1);
		}
		testCBG.move();
		for(ParticleBrush pb: testCBG)
		{
			assertTrue(pb.getY() == 1);
		}
	}
	
	
	@Test
	public void testWhetherComposingBrushesKineticsXAreMaintainedWhenMovingWithCenterBrush()
	{
		testCBG.setVelocityX(1);
		for(ParticleBrush pb: testCBG)
		{
			pb.setVelocity(1, 0);
		}
		testCBG.move();
		for(ParticleBrush pb: testCBG)
		{
			assertTrue(pb.getX() == 2);
		}
	}
}
