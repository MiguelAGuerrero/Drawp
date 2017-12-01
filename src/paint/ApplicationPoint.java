package paint;

public class ApplicationPoint
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

	public int compareTo(ApplicationPoint ap)
	{			
		double dx = this.getX() - ap.getX();
		double dy = this.getY() - ap.getY();
		double units = dx + dy;
		double origin = 0;
		return Double.compare(units, origin);
	}
}
