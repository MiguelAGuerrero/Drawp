package main;

import paint.Brush;
import paint.Canvas;
import paint.Converter;

public class Spiral implements Runnable
{
	Canvas canvas;
	Brush[] brushes;
	
	public Spiral(Canvas c, Brush... brushes)
	{
		this.canvas = c;
		this.brushes = brushes;
	}
	
	public void start()
	{
		int iterations = 5000;
		double deltaAngle = 0.10;
		double deltaRadius = 0.05;
		
		for(Brush b: brushes)
		{
			makeSpiral(b, iterations, deltaAngle, deltaRadius, 1);
		}
		
		Converter co = new Converter(canvas);
		co.convert("spiral.bmp");
	}
	
	private void makeSpiral(Brush brush, double iterations, double deltaAngle, double deltaRadius, int direction)
	{
		int x = 0;
		int y = 0;
		int cx = canvas.WIDTH / 2;
		int cy = canvas.HEIGHT / 2;
		
		double ang = 0;
		double radius = 0;
		while(iterations > 0)
		{
			double rad = Math.toRadians(ang);
			x = (int) (cx + direction * radius * Math.cos(rad));
			y = (int) (cy + direction * radius * Math.sin(rad));
			ang += deltaAngle;
			radius += deltaRadius;
			brush.apply(canvas);
			brush.moveTo(x, y);
			iterations--;
		}
	}
	
	@Override
	public void run(){
		start();
	}
}
