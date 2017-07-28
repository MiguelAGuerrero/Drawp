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
	
	public void apply(Brush brush, Bitmap<Integer> b)
	{
		for(int i = 0; i < shape.length; i++)
		{
			for(int j = 0; j < shape[i].length; j++)
			{
				int p = shape[i][j];
				if(p > 0)
				{
					int x = brush.x + centerX - i;
					int y = brush.y + centerY - j;
					int maxIntensity = 255;
					if(p == maxIntensity)
					{
						b.setPixel(x, y, brush.getColor());
					}
					
					else
					{
						//TODO: Scale the RGB value individually, not the int representation
						int scaledColor = brush.getColor() * p / maxIntensity;
						b.setPixel(x, y, scaledColor);
					}
				}
			}
		}
	}
}
