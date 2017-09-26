package main;

import paint.Brush;
import paint.Canvas;

public class Satellite extends Pattern
{
	public Satellite(Canvas c, Brush...brushes)
	{
		super(c, brushes);
	}
	
	public void draw()
	{
		double angle = 0;
		double deltaAngle = 0.05;
		int cx  = canvas.HEIGHT / 2;
		int cy = canvas.WIDTH / 2;
		int iterations = 10000;
		int radius = cx / 2;
		double brushRadius = radius / 4;
		for(Brush b: brushes)
		{
			for(int i = 0; i < iterations; i++)
			{
				double cosx = Math.cos(Math.toRadians(angle));
				double siny = Math.sin(Math.toRadians(angle));
				double refx = (cx + radius * cosx);
				double refy = (cy + radius * siny);
				b.moveTo(refx, refy);
				b.setColor(0x0000FF);
				b.apply(canvas);
				
				cosx = Math.cos(Math.toRadians(10 * angle));
				siny = Math.sin(Math.toRadians(10 * angle));
				double x = refx + brushRadius * cosx;
				double y = refy + brushRadius * siny;
				b.moveTo(x, y);
				b.apply(canvas);
				
				b.setColor(0x00FF00);
				cosx = Math.cos(Math.toRadians(20 * angle));
				siny = Math.sin(Math.toRadians(20 * angle));
				x = refx + 2 * brushRadius * cosx;
				y = refy + 2 * brushRadius * siny;
				b.moveTo(x, y);
				
				b.apply(canvas);
				angle += deltaAngle;
			}
		}
	}
}
