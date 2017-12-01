package drawp;

import java.awt.image.BufferedImage;

import paint.Brush;
import paint.PaintCanvas;

public abstract class DrawpSystem implements Runnable
{
	protected PaintCanvas canvas;
	protected Brush[] brushes;
	protected int frames;
	protected int curFrame = 0;
	
	public DrawpSystem(PaintCanvas c, Brush[] brushes)
	{
		this.canvas = c;
		this.brushes = brushes;
	}

	/**
	 * Updates the particle system by one frame. 
	 */
	public abstract void update();
	
	/**
	 * Applies particle brushes in system to 
	 * a canvas
	 */
	public abstract void draw();
	
	public abstract BufferedImage getImage();
	
	@Override
	public void run()
	{
		long start = System.currentTimeMillis();
		
		for (; curFrame < frames; curFrame++)
		{
			update();
			draw();
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Completed: " + this.getClass().getSimpleName());
		System.out.println(String.format("Time: %dms", end - start));
		canvas.save(this.getClass().getSimpleName());
	}
}

