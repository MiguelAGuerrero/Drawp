package paint;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

public class BrushShapeImpl implements BrushShape
{
	private static BrushShapeImpl pointPen;
	
	public static BrushShapeImpl pixelPointPen()
	{
		if(pointPen == null)
		{
			pointPen = new BrushShapeImpl();
			pointPen.setApplicationPoint(0, 0);	
		}
		
		 return pointPen;
	}
	
	private Collection<ApplicationPoint> points;
	
	public BrushShapeImpl()
	{
		points = new TreeSet<>();
	}
	
	public void setApplicationPoint(int x, int y)
	{
		points.add(new ApplicationPointImpl(x, y, ApplicationPointImpl.MAX_INTENSITY));
	}
	
	public void setApplicationPoint(ApplicationPoint ap)
	{
		points.add(ap);
	}
	
	public void setApplicationPoint(int x, int y, int intensity)
	{
		points.add(new ApplicationPointImpl(x, y, intensity));
	}

	public Iterator<ApplicationPoint> iterator()
	{
		return this.points.iterator();
	}
}
