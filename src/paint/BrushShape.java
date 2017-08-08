package paint;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

public class BrushShape implements Iterable<ApplicationPoint>
{
	private static BrushShape pointPen;
	private static int MAX_INTENSITY = 255;
	
	public static BrushShape pixelPointPen()
	{
		if(pointPen == null)
		{
			pointPen = new BrushShape();
			pointPen.setApplicationPoint(0, 0);	
		}
		
		 return pointPen;
	}
	
	private Collection<ApplicationPoint> points;
	
	public BrushShape()
	{
		points = new TreeSet<>();
	}
	
	public void setApplicationPoint(int x, int y)
	{
		points.add(new ApplicationPointImpl(x, y, MAX_INTENSITY));
	}
	
	public void setApplicationPoint(ApplicationPoint ap)
	{
		points.add(ap);
	}
	
	public void setApplicationPoint(int x, int y, int intensity)
	{
		points.add(new ApplicationPointImpl(x, y, intensity));
	}
	
	private static class ApplicationPointImpl implements ApplicationPoint
	{
		public double x;
		public double y;
		public int intensity = MAX_INTENSITY;
		
		public ApplicationPointImpl(double x, double y)
		{
			this.x = x;
			this.y = y;
		}
		
		public ApplicationPointImpl(double x, double y, int intensity)
		{
			this(x, y);
			this.intensity = intensity % MAX_INTENSITY;
		}


		@Override
		public double x()
		{
			return x;
		}

		@Override
		public double y()
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
			if(this.x() > ap.x()){ return 1; }
			else if(Double.compare(this.x(), ap.x()) == 0)
			{
				if(this.y() > ap.y()) { return 1; }
				if(Double.compare(this.y(), ap.y()) == 0) { return 0; }
				else return -1;
			}
			
			else return -1;
		}
	}

	public Iterator<ApplicationPoint> iterator()
	{
		return this.points.iterator();
	}
}
