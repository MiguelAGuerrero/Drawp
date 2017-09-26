package testphysics;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import physics.Particle;
import java.util.function.Consumer;
import java.util.function.Supplier; 

public class TestParticle
{
	public Particle p;
	private static double epsilon = 0.00001;
	
	@Before
	public void setUp() throws Exception
	{
		p = new Particle();
	}

	
	@Test
	public void testPositiveVelocityX()
	{
		double velX = 100;
		p.setVelocityX(velX);
		p.move();
		double expectedPosX = velX;
		assertEquals(p.getX(), expectedPosX, epsilon);
	}
	
	@Test
	public void testNegativeVelocityX()
	{
		double velX = -100;
		p.setVelocityX(velX);
		p.move();
		double expectedPosX = velX;
		assertEquals(p.getX(), expectedPosX, epsilon);
	}
	
	@Test
	public void testPositiveVelocityY()
	{
		double velY = 100;
		p.setVelocityY(velY);
		p.move();
		double expectedPosY = velY;
		assertEquals(p.getY(), expectedPosY, epsilon);
	}
	
	@Test
	public void testNegativeVelocityY()
	{
		double velY = -100;
		p.setVelocityY(velY);
		p.move();
		double expectedPosY = velY;
		assertEquals(p.getY(), expectedPosY, epsilon);
	}
	
	@Test
	public void testPositiveVelocityXY()
	{
		double vel = 100;
		p.setVelocity(vel, vel);
		p.move();
		assertEquals(p.getX() + p.getY(), 2 * vel, epsilon);
	}
	
	@Test
	public void testNegativeVelocityXY()
	{
		double vel = -100;
		p.setVelocity(vel, vel);
		p.move();
		assertEquals(p.getX() + p.getY(), 2 * vel, epsilon);
	}
	
	private void moveByFrames(Particle p, int frames)
	{
		for(int i = 0; i < frames; i++)
		{
			p.move();
		}
	}
}
