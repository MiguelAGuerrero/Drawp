package main;

import paint.Brush;
import paint.Canvas;
import paint.Converter;

public class Satellite extends Pattern
{
	public Satellite(Canvas c, Brush...brushes)
	{
		super(c, brushes);
	}
	
	public void draw()
	{
		double angle = 0;
		double deltaAngle = 0.5;
		int cx  = canvas.HEIGHT / 2;
		int cy = canvas.WIDTH / 2;
		int iterations = 1000;
		int radius = cx;
		double brushRadius = radius / 2;
		for(Brush b: brushes)
		{
			for(int i = 0; i < iterations; i++)
			{
				double cosx = Math.cos(Math.toRadians(angle));
				double siny = Math.sin(Math.toRadians(angle));
				double refx = (cx + radius * cosx);
				double refy = (cy + radius * siny);
				double x = refx + brushRadius * cosx;
				double y = refy + brushRadius * siny;
				b.moveTo(x, y);
				b.apply(canvas);
				angle += deltaAngle;
			}
		}

		converter.convert("Satellite.bmp");
	}
}
