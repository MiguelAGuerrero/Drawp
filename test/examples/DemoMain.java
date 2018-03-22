package examples;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import paint.Brush;
import paint.BrushShape;
import paint.PaintCanvas;

public class DemoMain
{
	public static void main(String[] args) throws IOException
	{
		
		Brush a = new Brush();
		Brush b = new Brush();
		
		int brushSize = 10;
		presetA(a, brushSize);
		//presetB(b, brushSize);
		Color color = Color.RED;
		a.setColor(color);
		b.setColor(color);
		
		int canvasSize = 500;
		PaintCanvas canvas = new PaintCanvas(canvasSize);

		int num_brushes = 10;
		Brush[] brushes = new Brush[num_brushes];
		for(int i = 0; i < num_brushes; i++)
		{
			brushes[i] = b;
		}
		
		new DrawpSystemDisplay(new SimpleDemo(canvas, brushes));
		
	}
	
	private static void presetA(Brush b, int brushShapeSize) throws IOException
	{
		BufferedImage bi = ImageIO.read(new File("C:\\Users\\Miguel Guerrero\\workspace\\Drawp\\test\\examples\\Untitled.jpg"));
		BrushShape bs = new BrushShape(bi);
		b.setShape(bs);
	}
	
	private static void presetB(Brush b, int brushShapeSize)
	{
		BrushShape bs = new BrushShape();
		bs = new BrushShape();
		int interval = 255 / brushShapeSize;
		for(int i = 1; i < brushShapeSize; i++)
			bs.addApplicationPoint(i, i, i * interval);
		
		b.setShape(bs);
	}
}
