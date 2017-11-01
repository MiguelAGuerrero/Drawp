package paint;

public class Brush implements Applicator
{	
	protected double x;
	protected double y;
	protected int color = 0x0;
	protected BrushShapeImpl brushShape;
	
	protected BlendType blendType;
	public Brush()
	{
		this.x = 0;
		this.y = 0;
		this.brushShape = BrushShapeImpl.pixelPointPen();
	}

	@Override
	public void apply(Bitmap<Integer> bitmap)
	{
		for(ApplicationPoint ap: brushShape)
		{
			int posX = (int) (this.x + ap.x());
			int posY = (int) (this.y + ap.y());
			int pixel = (ap.intensity() << Pixel.ALPHA_BITPOSITION) | this.getColor();	
			
			if(blendType != null)
			{
				//pixel = blendType.blend(pixel, bitmap.getPixel(posX, posY));
			}
			
			bitmap.setPixel(pixel, posX, posY);				
		}
	}
	
	public void moveTo(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public double x(){return this.x;}
	public double y(){return this.y;}
	
	public void setShape(BrushShapeImpl bs)
	{
		this.brushShape = bs;
	}
	
	public BrushShapeImpl getShape()
	{
		return this.brushShape;
	}
	
	public void setColor(int color)
	{
		this.color = color;
	}
	
	public int getColor()
	{
		return color;
	}
	
	public BlendType getBlendType()
	{
		return this.blendType;
	}
	
	public void setBlendType(BlendType bt)
	{
		this.blendType = bt;
	}
}
