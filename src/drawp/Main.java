package drawp;
import paint.Brush;
import paint.BrushShape;
import paint.Canvas;
import physics.ParticleSystem;
import testpaint.*;

public class Main
{
	public static void main(String[] args)
	{
		int cSize = 1000;
		Brush a = new Brush();
		Brush b = new Brush();
		int brushShapeSize = 20;
		BrushShape bs = new BrushShape();
	
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
		
		bs = new BrushShape();
		int interval = 255 / brushShapeSize;
		for(int i = 1; i < brushShapeSize; i++)
		{
			bs.setApplicationPoint(i, i, i * interval);
		}
		
		b.setShape(bs);
		
		int color = 0x00FF00FF;
		a.setColor(color);
		b.setColor(color);
		
		Canvas c = new Canvas(cSize);
		Brush[] brushArray = {a};
		Pattern p = new Test(c, brushArray);
		new Thread(p).start();
		System.out.println("Completed: " + p.getClass().getSimpleName());
	}
	
	public static void patterns()
	{
		//new Thread(new Spiral(new Canvas(cSize), a, b)).start();
		//new Thread(new Burst(new Canvas(cSize), a)).start();
		//new Thread(new Satellite(new Canvas(cSize), a)).start();
	}
}
