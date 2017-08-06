package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import physics.Particle;

public class ParticleTest {
	
	Particle p1;
	Particle p2;
	@Before
	public void setUp() throws Exception {
		p1 = new Particle();
		p2 = new Particle();
	}

	@Test
	public void testComparisonBetweenTwoParticlesAtDifferentXPositions()
	{
		int x1 = 1;
		p1.setX(x1);
		
		int x2 = 0;
		p2.setX(x2);
		
		assertTrue(p1.compareTo(p2) > 0);
	}
	
	@Test
	public void testComparisonBetweenTwoParticlesAtDifferentYPositions()
	{
		int y1 = 1;
		p1.setX(y1);
		
		int y2 = 0;
		p2.setX(y2);
		
		assertTrue(p1.compareTo(p2) > 0);
	}

	@Test
	public void testComparisonBetweenTwoParticlesAtDifferentXYPositions()
	{
		int x1 = 1;
		int y1 = 3;
		p1.setX(x1);
		p1.setY(y1);
		
		int x2 = -2;
		int y2 = -1;
		p2.setX(x2);
		p2.setY(y2);
		assertTrue(p1.compareTo(p2) > 0);
	}

}
