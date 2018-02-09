package drawp;

import paint.Applicator;
import paint.Pixmap;
import paint.Brush;
import particle.Particle;

public class ParticleBrush extends Particle implements Applicator
{
	private Brush brush;
	
	//For interpolation when pixel moves beyond just
	//1 pixel
	private double[] previousPos = {0, 0};
	
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
		double dx = Math.abs(getX() - this.previousPos[0]);
		double dy = Math.abs(getY() - this.previousPos[1]);
		double magnitude = (int) (dy / dx);

		//Interpolate if brush will move beyond just 1 pixel
		if(magnitude > 1)
		{
			//Normalize the change in position
			dx /= magnitude;
			dy /= magnitude;
			
			for(int i = 0; i <= magnitude; i++)
			{
				brush.moveTo(
						this.previousPos[0] + dx * i, 
						this.previousPos[1] + dy * i);
				brush.apply(b);
			}
		}
		
		else
		{
			brush.moveTo(getX(), getY());
			brush.apply(b);
		}
	}
	
	@Override
	public void setPosition(double x, double y)
	{
		//This is to make sure that the brushes do not drag along with
		//the sudden change in position
		storePosition(x, y);
		super.setPosition(x, y);
	}
	
	@Override 
	public void move()
	{
		storePosition(this.getX(), this.getY());
		super.move();
	}
	
	private void storePosition(double x, double y)
	{
		this.previousPos[0] = x;
		this.previousPos[1] = y;
	}
}
