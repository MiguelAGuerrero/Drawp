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
	
	//The value representing how dark a pixel needs to be
	//in order to be considered a application point.
	private final static int BLACKNESS_THRESHOLD = 10;
	
	public static BrushShape pixelPointPen()
	{
		if(pointPen == null)
		{
			pointPen = new BrushShape();
			pointPen.addApplicationPoint(0, 0);	
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
		//TODO: Implement: Use an image as a brush shape. 
		//to do this, I imagine that how black is will
		//determine whether or not it is an application
		//point.
		for(int i = 0; i < bi.getHeight(); i++)
			for(int j = 0; j < bi.getWidth(); j++)
			{
				int pixel = bi.getRGB(i, j);
				int intensity = Pixel.getAValue(pixel);
				int avg = Pixel.avgRGBValue(pixel);
				if(avg < BLACKNESS_THRESHOLD)
				{
					addApplicationPoint(i, j, intensity);
				}
			}
	}
	
	public void addApplicationPoint(int x, int y)
	{
		points.add(new ApplicationPoint(x, y, 
				ApplicationPoint.MAX_INTENSITY));
	}
	
	public void addApplicationPoint(int x, int y, int intensity)
	{
		points.add(new ApplicationPoint(x, y, intensity));
	}

	public Iterator<ApplicationPoint> iterator()
	{
		return this.points.iterator();
	}
}
