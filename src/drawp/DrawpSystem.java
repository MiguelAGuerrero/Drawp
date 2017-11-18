package drawp;

import paint.Brush;
import paint.Canvas;

public abstract class DrawpSystem implements Runnable
{
	protected Canvas canvas;
	protected Brush[] brushes;
	protected int frames;
	protected int curFrame = 0;
	
	public DrawpSystem(Canvas c, Brush[] brushes)
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
		System.out.format("Time: %dms", end - start);
		canvas.save(this.getClass().getSimpleName());
	}
}

