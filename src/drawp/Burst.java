package drawp;

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
			final int DEGREES_IN_CIRCLE = 360;
			final double deltaAngle = DEGREES_IN_CIRCLE / units;
			
			for(int i = 0; i < units; i++)
			{
				double dx =  Math.cos(Math.toRadians(i * deltaAngle));
				double dy = Math.sin(Math.toRadians(i * deltaAngle));
				stroke(b, iterations, dx, dy);
			}
		}
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
