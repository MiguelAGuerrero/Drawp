package paint;

public class Brush implements Applicator
{	
	protected int x;
	protected int y;
	protected int color = 0x0;
	protected BrushShape shape;
	
	public Brush()
	{
		this.x = 0;
		this.y = 0;
		this.shape = BrushShape.pixelPointPen();
	}

	@Override
	public void apply(Bitmap<Integer> b)
	{
		this.shape.apply(this, b);
	}
	
	public void moveTo(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
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
		this.shape = bs;
	}
}
