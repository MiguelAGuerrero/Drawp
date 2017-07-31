package main;
import paint.*;

public class Main
{
	public static void main(String[] args)
	{
		int cSize = 1000;
		Brush a = new Brush();
		Brush b = new Brush();
		a.setColor(0x0000FF);
		b.setColor(0xFF0000);
		int brushShapeSize = 10;
		BrushShape bs = new BrushShape(brushShapeSize);
		
		for(int i = 0; i < brushShapeSize; i++)
		{
			bs.setApplicationPoint(i, i / 2, i * 255 / brushShapeSize);
		}
		
		a.setShape(bs);
		b.setShape(bs);
		
		//new Thread(new Spiral(new Canvas(cSize), a)).start();
		new Thread(new Burst(new Canvas(cSize), a)).start();
	}
}
