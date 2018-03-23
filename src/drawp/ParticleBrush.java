package drawp;

import java.awt.geom.Point2D;

import paint.Applicator;
import paint.Pixmap;
import paint.Brush;
import particle.Particle;

public class ParticleBrush extends Particle implements Applicator
{
	private Brush brush;
	private boolean up = false;
	//For interpolation when pixel moves beyond just
	//1 pixel
	private int[] previousPos = {0, 0};
	
	public ParticleBrush()
	{
		this.brush = new Brush();
	}
	
	public ParticleBrush(Brush brush)
	{
		this.brush = brush;
	}
	
	public Brush getBrush()
	{
		return this.brush;
	}
	
	public void up(boolean up) 
	{
		this.up = up;
	}
	
	@Override
	public void apply(Pixmap p)
	{ 
		if(!up) {
			drag(	p,
					getPrevX(), 
					getPrevY(), 
					(int) Math.round(getX()), 
					(int) Math.round(getY()));
		}
	}
	
	@Override
	public void setLocation(double x, double y)
	{
		//This is to make sure that the brushes do not  drag along with
		//the sudden change in position
		storePosition((int) getX(), (int) getY());
		super.setLocation(x, y);
	}
	
	/** 
	 * Bresenham's line algorithm
	 */
	private void drag(Pixmap p, int x, int y, int x2, int y2)
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
			brush.setPosition(x, y);
			brush.apply(p);
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
	
	@Override 
	public void move()
	{
		storePosition(
				(int) Math.round(this.getX()), 
				(int) Math.round(this.getY()));
		super.move();
	}
	
	private void storePosition(int x, int y)
	{
		this.previousPos[0] = x;
		this.previousPos[1] = y;
	}
	
	private int getPrevX()
	{
		return previousPos[0];
	}
	
	private int getPrevY()
	{
		return previousPos[1];
	}
}
