package main;
import paint.*;
import physics.ParticleSystem;

public class Main
{
	public static void main(String[] args)
	{
		int cSize = 500;
		Brush a = new Brush();
		Brush b = new Brush();
		a.setColor(0x0000FF);
		b.setColor(0xFF0000);
		int brushShapeSize = 20;
		BrushShape bs = new BrushShape(brushShapeSize);
		
		int radius = brushShapeSize / 2;
	
		for(int i = 0; i < brushShapeSize; i++)
		{
			int angle = i  * 360 / brushShapeSize;
			int offset = radius - 1;
			int x = (int) (radius + offset *  Math.cos(Math.toRadians(angle)));
			int y = (int) (radius + offset *  Math.sin(Math.toRadians(angle)));
			bs.setApplicationPoint(x, y);
		}
		
		a.setShape(bs);
		
		bs = new BrushShape(brushShapeSize);
		for(int i = 1; i < brushShapeSize; i++)
		{
			bs.setApplicationPoint(i, i, i * 255 / i);
		}
		
		b.setShape(bs);
		
		new Thread(new Particles(new Canvas(cSize), b, b, b, b)).start();
	}
	
	public static void patterns()
	{
		//new Thread(new Spiral(new Canvas(cSize), a, b)).start();
		//new Thread(new Burst(new Canvas(cSize), a)).start();
		//new Thread(new Satellite(new Canvas(cSize), a)).start();
		
	}
}
