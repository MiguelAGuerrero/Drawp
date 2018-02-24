package paint;

import java.awt.geom.Point2D;

public class ApplicationPoint
{
	public static int MAX_INTENSITY = 255;
	
	public int x;
	public int y;
	public int intensity;
	
	public ApplicationPoint(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.intensity = MAX_INTENSITY;
	}
	
	public ApplicationPoint(int x, int y, int intensity)
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
	
	public void setLocation(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}
