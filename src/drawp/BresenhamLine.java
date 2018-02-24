package drawp;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import static java.lang.Math.abs;

/**
 * Adapted from https://en.wikipedia.org/wiki/Bresenham's_line_algorithm
 * @author Miguel Guerrero
 */

public class BresenhamLine
{
	private ArrayList<Point2D> points;
	private int marker = 0;
	private final int DEFAULT_SIZE = 100;
	public BresenhamLine() 
	{	
		this.points = new ArrayList<>(DEFAULT_SIZE);
		growBuffer(DEFAULT_SIZE);
	}
	
	public void interpolate(int x0, int y0, int x1, int y1) 
	{	
		marker = 0;
		int dx = x1 - x0;
		int dy = y1 - y0;
		if(abs(dy) < abs(dx))
		{
			if(x0 > x1) 
				interpolateLow(x1, y1, x0, y0);
			else 
				interpolateLow(x0, y0, x1, y1);
		}
		else
		{	if(x0 > x1) 
				interpolateHigh(x1, y1, x0, y0);
			else 
				interpolateHigh(x0, y0, x1, y1);
		}
	}
	
	private void interpolateHigh(int x0, int y0, int x1, int y1)
	{
		int dx = x1 - x0;
		int dy = y1 - y0;
		int xi = 1;
		if(dx < 0) 
		{
			xi = -1;
			dx = -dx;
		}
		int error = 2 * dx - dy;
		int x = x0;
		for(int y = y0; y <= y1; y++)
		{
			plot(x, y);
			if (error > 0)
			{
				x = x + xi;
				error = error - 2 * dy;
			}
			
			error = error + 2 * dx;
		}
		
	}
	private void interpolateLow(int x0, int y0, int x1, int y1) 
	{
		int dx = x1 - x0;
		int dy = y1 - y0;
		int yi = 1;
		if(dy < 0) 
		{
			yi = -1;
			dy = -dy;
		}
		int error = 2 * dy - dx;
		int y = y0;
		for(int x = x0; x <= x1; x++)
		{
			plot(x, y);
			if (error > 0)
			{
				y = y + yi;
				error = error - 2 * dx;
			}
			
			error = error + 2 * dy;
		}
	}
	
	private void plot(int x, int y) 
	{
		int size = this.points.size();
		if(marker >= size) 
		{
			growBuffer(size);
		}
		
		Point2D point = this.points.get(marker);
		point.setLocation(x, y);
		marker++;
	}
	
	private void growBuffer(int size) 
	{
		for(int i = 0; i < size; i++) 
		{
			this.points.add(new Point2D.Double());
		}
	}
	
	public Point2D[] getPoints() 
	{
		Point2D[] points = new Point2D[marker];
		for(int i = 0; i < marker; i++) 
		{
			points[i] = this.points.get(i);
		}
		
		return points;
	}
}
