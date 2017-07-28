package main;

import paint.Brush;
import paint.Canvas;
import paint.Converter;

public class Spiral implements Runnable
{
	Canvas canvas;
	Brush brush;
	
	public Spiral(Canvas c, Brush brush)
	{
		this.canvas = c;
		this.brush = brush;
	}
	
	public void start()
	{
		int iterations = 1000;
		for(int i = 0; i < 10; i++)
		{
			makeSpiral(iterations, 1, 0.05 + i * 0.05, 1);
		}
		
		Converter co = new Converter(canvas);
		co.convert("spiral.bmp");
	}
	
	private void makeSpiral(double iterations, double deltaAngle, double deltaRadius, int direction)
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
			brush.setColor(brush.getColor() + 10);
			iterations--;
		}
	}
	
	@Override
	public void run(){
		start();
	}
}
