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
		a.setColor(0x00000F);
		b.setColor(0x1111);
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
		
		int color = 0xFFFFFFFF;
		a.setColor(color);
		b.setColor(color);
		
		Canvas c = new Canvas(cSize);
		Brush[] brushArray = {b};
		new Thread(new Test(c, brushArray)).start();
	}
	
	public static void patterns()
	{
		//new Thread(new Spiral(new Canvas(cSize), a, b)).start();
		//new Thread(new Burst(new Canvas(cSize), a)).start();
		//new Thread(new Satellite(new Canvas(cSize), a)).start();
	}
}
