package drawp;

import paint.Brush;
import paint.Canvas;
import paint.Converter;

public class Spiral extends Pattern
{
	public Spiral(Canvas c, Brush[] brushes, int frames)
	{
		super(c, brushes, frames);
	}

	Canvas canvas;
	Brush[] brushes;


	public void draw()
	{
		double deltaAngle = 0.1;
		double deltaRadius = 0.05;

		for(Brush b: brushes)
		{
			spiral(b, deltaAngle, deltaRadius, 1);
		}

		Converter co = new Converter(canvas);
		co.convert("spiral.bmp");
	}

	private void spiral(Brush brush, double deltaAngle, double deltaRadius, int direction)
	{
		int x = 0;
		int y = 0;
		int cx = canvas.WIDTH / 2;
		int cy = canvas.HEIGHT / 2;

		double ang = 0;
		double radius = 0;
		double rad = Math.toRadians(ang);
		x = (int) (cx + direction * radius * Math.cos(rad));
		y = (int) (cy + direction * radius * Math.sin(rad));
		ang += deltaAngle;
		radius += deltaRadius;
		brush.apply(canvas);
		brush.moveTo(x, y);
	}
}
