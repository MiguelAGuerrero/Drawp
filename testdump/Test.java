package drawp;

import paint.BlendType;
import paint.Brush;
import paint.Canvas;

public class Test extends Pattern
{
	private int curFrame = 0;
	public Test(Canvas c, Brush[] brushes, int frames)
	{
		super(c, brushes, frames);
	}

	@Override
	public void draw(){
		Brush b = brushes[0];
		int cx = canvas.WIDTH / 2;
		int cy = canvas.HEIGHT / 2;
		b.moveTo(cx, cy);
		int r = 250;
		int t = 100;
		double a = Math.toRadians(curFrame);
		curFrame++;
		double f = 0.2;
		double x = (r - t * Math.sin(a * f)) * Math.cos(a);
		double y = (r - t * Math.cos(a * f)) * Math.sin(a);
		b.moveTo(cx + x, cy + y);
		b.apply(canvas);
	}
}
