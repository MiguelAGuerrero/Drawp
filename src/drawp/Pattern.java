package drawp;

import paint.Brush;
import paint.Canvas;
import paint.Converter;

public abstract class Pattern implements Runnable
{
	protected Canvas canvas;
	protected Brush[] brushes;
	protected Converter converter;
	
	public Pattern(Canvas c, Brush... brushes)
	{
		this.canvas = c;
		this.brushes = brushes;
		this.converter = new Converter(c);
	}

	public abstract void draw();
	
	@Override
	public void run()
	{
		draw();
		converter.convert(this.getClass().getSimpleName() + ".bmp");
	}
}
