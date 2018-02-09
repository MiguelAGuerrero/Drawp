package paint;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class BrushShape implements Iterable<ApplicationPoint>
{
	private static BrushShape pointPen;
	
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
		points = new LinkedList<>();
	}
	
	public BrushShape(BufferedImage bi)
	{
		this();
		for(int i = 0; i < bi.getHeight(); i++)
			for(int j = 0; j < bi.getWidth(); j++)
			{
				int pixel = bi.getRGB(i, j);
				int intensity = Pixel.getAValue(pixel);
				setApplicationPoint(i, j, intensity);
			}
	}
	
	private void getPixelDarkness(int pixel)
	{
		
	}
	
	public void setApplicationPoint(int x, int y)
	{
		points.add(new ApplicationPoint(x, y, 
				ApplicationPoint.MAX_INTENSITY));
	}
	
	public void setApplicationPoint(int x, int y, int intensity)
	{
		points.add(new ApplicationPoint(x, y, intensity));
	}

	public Iterator<ApplicationPoint> iterator()
	{
		return this.points.iterator();
	}
}
