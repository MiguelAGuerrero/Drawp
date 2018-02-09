package paint;

import java.awt.geom.Point2D;

public class ApplicationPoint extends Point2D
{
	public static int MAX_INTENSITY = 255;
	
	public double x;
	public double y;
	public int intensity;
	
	public ApplicationPoint(double x, double y)
	{
		this.x = x;
		this.y = y;
		this.intensity = MAX_INTENSITY;
	}
	
	public ApplicationPoint(double x, double y, int intensity)
	{
		this.x = x;
		this.y = y;
		this.intensity = intensity;
	}

	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}

	public int intensity()
	{
		return intensity;
	}
	
	@Override
	public void setLocation(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
}
