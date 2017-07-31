package main;

import paint.Brush;
import paint.Canvas;
import paint.Converter;

public class Burst extends Pattern
{
	public Burst(Canvas c, Brush... brushes)
	{
		super(c, brushes);
	}
	
	public void draw()
	{
		int iterations = 500;
		
		for(Brush b: brushes)
		{
			int units = 10;
			int DEGREES_IN_CIRCLE = 360;
			
			for(int i = 0; i < units; i += DEGREES_IN_CIRCLE / units)
			{
				double dx =  Math.cos(Math.toRadians(i));
				double dy = Math.sin(Math.toRadians(i));
				stroke(b, iterations, dx, dy);
			}
		}
		
		Converter co = new Converter(canvas);
		co.convert("burst.bmp");
	}
	
	private void stroke(Brush brush, double iterations, double dx, double dy)
	{
		int cx = canvas.WIDTH / 2;
		int cy = canvas.HEIGHT / 2;
		brush.moveTo(cx, cy);
		
		for(; iterations > 0; iterations--)
		{
			brush.apply(canvas);
			brush.moveTo(brush.x() + dx,  brush.y() + dy);
		}
	}
}
