package main;

import paint.Applicator;
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
		int iterations = 10000;
		spiral(iterations, 1, 0.05, 1);
		spiral(iterations, 1, 0.05, -1);
		
		Converter co = new Converter(canvas);
		co.convert("spiral.bmp");
	}
	
	private void spiral(double iterations, double da, double dr, int dir)
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
			x = (int) (cx + dir * radius * Math.cos(rad));
			y = (int) (cy + dir * radius * Math.sin(rad));
			ang += da;
			radius += dr;
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
