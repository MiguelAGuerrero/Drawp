package paint;

public class ApplicationPointImpl implements ApplicationPoint
{
	public static int MAX_INTENSITY = 255;
	
	public double x;
	public double y;
	public int intensity;
	
	public ApplicationPointImpl(double x, double y)
	{
		this.x = x;
		this.y = y;
		this.intensity = MAX_INTENSITY;
	}
	
	public ApplicationPointImpl(double x, double y, int intensity)
	{
		this.x = x;
		this.y = y;
		this.intensity = intensity;
	}

	@Override
	public double getX()
	{
		return x;
	}

	@Override
	public double getY()
	{
		return y;
	}

	@Override
	public int intensity()
	{
		return intensity;
	}

	@Override
	public int compareTo(ApplicationPoint ap)
	{			
		double dx = this.getX() - ap.getX();
		double dy = this.getY() - ap.getY();
		double units = dx + dy;
		double origin = 0;
		return Double.compare(units, origin);
	}
}
