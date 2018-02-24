package paint;

import java.awt.Color;

public class Brush implements Applicator
{	
	private int x;
	private int y;
	private int color = 0x0;
	private BrushShape brushShape;
	private Blender<Integer> blendType;
	
	public Brush()
	{
		this.x = 0;
		this.y = 0;
		this.brushShape = BrushShape.pixelPointPen();
		this.blendType = BlendType.NORMAL;
	}

	@Override
	public void apply(Pixmap bitmap)
	{
		for(ApplicationPoint ap: brushShape)
		{
			int targetX = (int) (this.getX() + ap.getX());
			int targetY = (int) (this.getY() + ap.getY());
			
			int pixel = (ap.intensity() << Pixel.ALPHA_BITPOSITION) 
					| this.getColor();
			
			pixel = blendType.blend(pixel, bitmap.getPixel(targetX, targetY));
			
			bitmap.setPixel(pixel, targetX, targetY);				
		}
	}
	
	public void setPosition(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getX(){ return this.x; }
	public int getY(){ return this.y; }
	
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
	
	public Blender<Integer> getBlend()
	{
		return this.blendType;
	}
	
	public void setBlend(Blender<Integer> bt)
	{
		this.blendType = bt;
	}
}
