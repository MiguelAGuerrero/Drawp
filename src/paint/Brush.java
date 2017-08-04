package paint;

public class Brush implements Applicator
{	
	protected double x;
	protected double y;
	protected int color = 0x0;
	protected BrushShape brushShape;
	
	//TODO: Incorporate blending
	public enum BlendType {NORMAL, ADD, SUBTRACT};
	
	public Brush()
	{
		this.x = 0;
		this.y = 0;
		this.brushShape = BrushShape.pixelPointPen();
	}

	@Override
	public void apply(Bitmap<Integer> b)
	{
		int[][] shape = brushShape.getShape();
		apply(b, shape, this.x / 2, this.y / 2);
	}
	
	protected void apply(Bitmap<Integer> b, int[][] shape, double offsetX, double offsetY)
	{
		for(int i = 0; i < shape.length; i++)
		{
			for(int j = 0; j < shape[i].length; j++)
			{
				int p = shape[i][j];
				if(p > 0)
				{
					int newX = (int) (this.x + offsetX - i);
					int newY = (int) (this.y + offsetY - j);
					b.setPixel(newX, newY, p << Pixel.ALPHA_BITPOSITION & this.getColor());				
				}
			}
		}
	}
	
	public void moveTo(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void moveTo(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public double x(){return this.x;}
	public double y(){return this.y;}
	
	public void setColor(int color)
	{
		this.color = color;
	}
	
	public int getColor()
	{
		return color;
	}
	
	public void setShape(BrushShape bs)
	{
		this.brushShape = bs;
	}
}
