package paint;

import java.util.Arrays;

public class BrushShape
{
	private static BrushShape pointPen;
	public static BrushShape pixelPointPen()
	{
		if(pointPen == null)
		{
			pointPen = new BrushShape(1);
			pointPen.setApplicationPoint(0, 0);	
		}
		
		 return pointPen;
	}
	
	int[][] shape;
	int centerX;
	int centerY;
	
	public BrushShape(int size)
	{
		shape = new int[size][size];
		for(int[] row: shape)
		{
			Arrays.fill(row, 0);
		}
	}
	
	public void setApplicationPoint(int x, int y)
	{
		this.shape[x][y] = 255;
	}
	
	public void setApplicationPoint(int x, int y, int intensity)
	{
		this.shape[x][y] = intensity;
	}
	
	public int[][] getShape(){return shape;}
	
	public void apply(Brush brush, Bitmap<Integer> b)
	{
	}
}
