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
		double velX = 3;
		double velY = 4;
		p.setVelocity(velX, velY);
		p.move();
		double dist = Math.hypot(p.getVelocityX(), p.getVelocityY());
		double expectedDist = 5; 
		assertEquals(dist, expectedDist, epsilon);
	}
	
	@Test
	public void testNegativeVelocityXY()
	{
		double velX = -3;
		double velY = -4;
		p.setVelocity(velX, velY);
		p.move();
		double dist = Math.hypot(p.getVelocityX(), p.getVelocityY());
		double expectedDist = 5; 
		assertEquals(dist, expectedDist, epsilon);
	}
	
	@Test
	public void testPositiveAccelX()
	{
		double accelX = 1;
		p.setAccelX(accelX);
		moveByFrames(p, 2);
		double expectedPosX = accelX;
		assertEquals(p.getX(), expectedPosX, epsilon);
	}
	
	@Test
	public void testPositiveAccelY()
	{
		double accelY = 1;
		p.setAccelerationY(accelY);
		int displacementFrame = 2;
		moveByFrames(p, displacementFrame);
		double expectedPosY = accelY;
		assertEquals(p.getY(), expectedPosY, epsilon);
	}
	
	@Test
	public void testPositiveAccelXY()
	{
		double accelX = 1;
		double accelY = 1;
		p.setAcceleration(accelX, accelY);
		int displacementFrame = 2;
		moveByFrames(p, displacementFrame);
		double pos = Math.hypot(p.getX(), p.getY());
		double expectedPos = Math.pow(2, 0.5);
		assertEquals(pos, expectedPos, epsilon);
	}
	
	@Test
	public void testNoChangeInPosFromSetAngleAtRestState()
	{
		double angle = 45;
		double x1 = p.getX();
		double y1 = p.getY();
		p.setAngle(angle);
		double x2 = p.getX();
		double y2 = p.getY();
		assertEquals(Math.hypot(x1, y1), Math.hypot(x2, y2), epsilon);
	}
	
	@Test
	public void testChangeIn()
	{
		double angle = 45;
		double x1 = p.getX();
		double y1 = p.getY();
		p.setAngle(angle);
		double x2 = p.getX();
		double y2 = p.getY();
		assertEquals(Math.hypot(x1, y1), Math.hypot(x2, y2), epsilon);
	}
	
	private void moveByFrames(Particle p, int frames)
	{
		for(int i = 0; i < frames; i++)
		{
			p.move();
		}
	}
}
