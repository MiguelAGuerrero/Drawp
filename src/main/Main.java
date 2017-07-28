package main;
import paint.*;

public class Main
{
	public static void main(String[] args)
	{
		Canvas c = new Canvas(1000);
		c.fill(0x0);
		Brush a = new Brush();
		a.setColor(0xff00ff);
		
		int size = 10;
		BrushShape bs = new BrushShape(size);
		
		for(int i = 0; i < size; i++)
		{
			bs.setApplicationPoint(i, i);
		}
		
		a.setShape(bs);
		new Thread(new Spiral(c, a)).start();
	}
}
