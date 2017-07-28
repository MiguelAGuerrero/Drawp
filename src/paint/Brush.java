package paint;

public class Brush implements Applicator
{
	private static BrushShape DEFAULT_SHAPE = new BrushShape(1);
	protected int x;
	protected int y;
	protected int color = 0x0;
	protected BrushShape shape;
	
	public Brush()
	{
		this.x = 0;
		this.y = 0;
		this.shape = DEFAULT_SHAPE;
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
}
