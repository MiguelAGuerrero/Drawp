package paint;

public class Brush implements Applicator
{	
	protected double x;
	protected double y;
	protected int color = 0x0;
	protected BrushShape brushShape;
	
	public Brush()
	{
		this.x = 0;
		this.y = 0;
		this.brushShape = BrushShape.pixelPointPen();
	}

	@Override
	public void apply(Bitmap<Integer> b)
	{
		for(ApplicationPoint ap: brushShape)
		{
			int posX = (int) (this.x + ap.x());
			int posY = (int) (this.y + ap.y());
			int pixel = ap.intensity() << Pixel.ALPHA_BITPOSITION & this.getColor();
			b.setPixel(posX, posY, pixel);				
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
