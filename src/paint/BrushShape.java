package paint;

import java.util.Arrays;

public class BrushShape
{
	ApplicationPoint[][] shape;
	int centerX;
	int centerY;
	
	public BrushShape(int size)
	{
		shape = new ApplicationPoint[size][size];
		for(ApplicationPoint[] row: shape)
		{
			Arrays.fill(row, new ApplicationPoint(0));
		}
	}
	
	public void setApplicationPoint(int x, int y)
	{
		this.shape[x][y] = new ApplicationPoint(255);
	}
	
	public void setApplicationPoint(int x, int y, int intensity)
	{
		this.shape[x][y] = new ApplicationPoint(intensity);
	}
	
	public void apply(Brush brush, Bitmap<Integer> b)
	{
		for(int i = 0; i < shape.length; i++)
		{
			for(int j = 0; j < shape[i].length; j++)
			{
				ApplicationPoint p = shape[i][j];
				if(p.applicable())
				{
					int x = brush.x + centerX - i;
					int y = brush.y + centerY - j;
					int maxIntensity = ApplicationPoint.MAX_INTENSITY;
					if(p.intensity == maxIntensity)
					{
						b.setPixel(x, y, brush.getColor());
					}
					
					else
					{
						int scaledColor = brush.getColor() * p.intensity / maxIntensity;
						b.setPixel(x, y, scaledColor);
					}
				}
			}
		}
	}
	
	private static class ApplicationPoint
	{
		final int intensity;
		
		public ApplicationPoint( int intensity)
		{
			this.intensity = intensity;
		}
		
		public boolean applicable()
		{
			return intensity > 0;
		}
		
		public static int MAX_INTENSITY = 255;
		
	}
}
