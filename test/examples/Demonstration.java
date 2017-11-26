package examples;

import java.awt.Color;

import drawp.DrawpSystemDisplay;
import paint.Brush;
import paint.BrushShapeImpl;
import paint.PaintCanvas;

public class Demonstration
{
	public static void main(String[] args)
	{
		int cSize = 1000;
		Brush a = new Brush();
		Brush b = new Brush();
		int brushShapeSize = 10;
		BrushShapeImpl bs = new BrushShapeImpl();
	
		int radius = brushShapeSize / 2;
		for(int i = 0; i < brushShapeSize; i++)
		{
			int angle = i  * 360 / brushShapeSize;
			int offset = radius - 1;
			int x = (int) (radius + offset *  Math.cos(Math.toRadians(angle)));
			int y = (int) (radius + offset *  Math.sin(Math.toRadians(angle)));
			bs.setApplicationPoint(x, y);
		}
		
		//a.setShape(bs);
		
		bs = new BrushShapeImpl();
		int interval = 255 / brushShapeSize;
		for(int i = 1; i < brushShapeSize; i++)
		{
			bs.setApplicationPoint(i, i, i * interval);
		}
		
		b.setShape(bs);
		
		Color color = Color.GREEN;
		a.setColor(color);
		b.setColor(color);
		
		PaintCanvas c = new PaintCanvas(cSize);

		int num_brushes = 50;
		Brush[] brushes = new Brush[num_brushes];
		for(int i = 0; i < num_brushes; i++){
			brushes[i] = b;
		}
		
		DrawpSystemDisplay dsd = new DrawpSystemDisplay(new Particles(c, brushes, 10000));
		
	}
}
