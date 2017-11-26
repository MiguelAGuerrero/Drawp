package paint;

import java.awt.Color;

public class Brush implements Applicator
{	
	private double x;
	private double y;
	private int color = 0x0;
	private BrushShape brushShape;
	private Blender<Integer> blendType;
	
	public Brush()
	{
		this.x = 0;
		this.y = 0;
		this.brushShape = BrushShapeImpl.pixelPointPen();
		this.blendType = BlendType.SUBTRACT;
		this.blendType.setDestBlendFactor(0.5);
		this.blendType.setSrcBlendFactor(1);
	}

	@Override
	public void apply(Pixmap bitmap)
	{
		for(ApplicationPoint ap: brushShape)
		{
			int posX = (int) (this.x + ap.getX());
			int posY = (int) (this.y + ap.getY());
			int pixel = (ap.intensity() << Pixel.ALPHA_BITPOSITION) | this.getColor();
			
			if(blendType != null)
			{
				pixel = blendType.blend(pixel, bitmap.getPixel(posX, posY));
			}
			
			bitmap.setPixel(pixel, posX, posY);				
		}
	}
	
	public void moveTo(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public double x(){ return this.x; }
	public double y(){ return this.y; }
	
	public void setShape(BrushShape bs)
	{
		this.brushShape = bs;
	}
	
	public BrushShape getShape()
	{
		return this.brushShape;
	}
	
	public void setColor(Color c)
	{
		this.color = c.getRGB();
	}
	
	public void setColor(int color)
	{
		this.color = color;
	}
	
	public int getColor()
	{
		return color;
	}
	
	public Blender getBlendType()
	{
		return this.blendType;
	}
	
	public void setBlendType(BlendType bt)
	{
		this.blendType = bt;
	}
}
