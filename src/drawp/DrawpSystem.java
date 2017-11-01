package drawp;

import paint.Brush;
import paint.Canvas;
import paint.Converter;

public abstract class DrawpSystem implements Runnable
{
	protected Canvas canvas;
	protected Brush[] brushes;
	protected Converter converter;
	protected int frames;
	protected int curFrame = 0;
	
	public DrawpSystem(Canvas c, Brush[] brushes, int frames)
	{
		this.canvas = c;
		this.brushes = brushes;
		this.converter = new Converter(c);
		this.frames = frames;
	}

	public abstract void draw();
	
	@Override
	public void run()
	{
		long start = System.currentTimeMillis();
		for (; curFrame < frames; curFrame++)
		{
			draw();
		}
		long end = System.currentTimeMillis();
		System.out.println("Completed: " + this.getClass().getSimpleName());
		System.out.format("Time: %dms", end - start);
		converter.convert(this.getClass().getSimpleName() + ".bmp");
	}
}
