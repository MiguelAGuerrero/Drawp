package drawp;

import java.awt.geom.Point2D;

import paint.Applicator;
import paint.Pixmap;
import paint.Brush;
import particle.Particle;

public class ParticleBrush extends Particle implements Applicator
{
	private Brush brush;
	
	//For interpolation when pixel moves beyond just
	//1 pixel
	private int[] previousPos = {0, 0};
	private LineInterpolater bl = new LineInterpolater();
	
	public ParticleBrush()
	{
		this.brush = new Brush();
	}
	
	public ParticleBrush(Brush brush)
	{
		this.brush = brush;
	}
	
	public Brush getBrush()
	{
		return this.brush;
	}
	
	@Override
	public void apply(Pixmap b)
	{ 
		int dx = (int) Math.round(getX() - this.getPrevX());
		int dy = (int) Math.round(getY() - this.getPrevY());
		double magnitude = Math.hypot(dx, dy);

		//Interpolate if brush will move beyond just 1 pixel
		if(magnitude > 1)
		{
			bl.line(
					getPrevX(), 
					getPrevY(), 
					(int) Math.round(getX()), 
					(int) Math.round(getY()));
			
			for(Point2D p: bl.getPoints())
			{
				brush.setPosition((int) p.getX(), (int) p.getY());
				brush.apply(b);
			}
		}
		
		else
		{
			brush.setPosition(
					(int) Math.round(this.getX()), 
					(int) Math.round(this.getY()));
			brush.apply(b);
		}
	}
	
	public void setLocation(int x, int y)
	{
		//This is to make sure that the brushes do not  drag along with
		//the sudden change in position
		storePosition(x, y);
		super.setLocation(x, y);
	}
	
	@Override 
	public void move()
	{
		storePosition(
				(int) Math.round(this.getX()), 
				(int) Math.round(this.getY()));
		super.move();
	}
	
	private void storePosition(int x, int y)
	{
		this.previousPos[0] = x;
		this.previousPos[1] = y;
	}
	
	private int getPrevX()
	{
		return previousPos[0];
	}
	
	private int getPrevY()
	{
		return previousPos[1];
	}
}
