package drawp;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import static java.lang.Math.abs;

/**
 * Using the implementation found
 * from http://tech-algorithm.com/articles/drawing-line-using-bresenham-algorithm/
 * 
 * @author Miguel Guerrero
 */

public class LineInterpolater
{
	private ArrayList<Point2D> points;
	private int marker = 0;
	private final int DEFAULT_SIZE = 100;
	public LineInterpolater() 
	{	
		this.points = new ArrayList<>(DEFAULT_SIZE);
		
		//Create a buffer a points to avoid redundant class creation
		growBuffer(DEFAULT_SIZE);
	}

	
	public void line(int x,int y,int x2, int y2)
	{
	    int w = x2 - x ;
	    int h = y2 - y ;
	    int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0 ;
	    if (w<0) dx1 = -1 ; else if (w>0) dx1 = 1 ;
	    if (h<0) dy1 = -1 ; else if (h>0) dy1 = 1 ;
	    if (w<0) dx2 = -1 ; else if (w>0) dx2 = 1 ;
	    int longest = Math.abs(w) ;
	    int shortest = Math.abs(h) ;
	    if (!(longest>shortest))
	    {
	        longest = Math.abs(h) ;
	        shortest = Math.abs(w) ;
	        if (h<0) dy2 = -1 ; else if (h>0) dy2 = 1 ;
	        dx2 = 0 ;            
	    }
	    
	    int numerator = longest >> 1 ;
	    for (int i=0;i<=longest;i++)
	    {
	        plot(x,y) ;
	        numerator += shortest ;
	        if (!(numerator<longest)) {
	            numerator -= longest ;
	            x += dx1 ;
	            y += dy1 ;
	        } else {
	            x += dx2 ;
	            y += dy2 ;
	        }
	    }
	}

	private void plot(int x, int y) 
	{

		expandBufferIfNeccesary();
		
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
	
	private void expandBufferIfNeccesary() 
	{
		int size = this.points.size();
		if(marker >= size) 
		{
			growBuffer(size);
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
