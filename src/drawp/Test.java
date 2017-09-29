package drawp;

import paint.BlendType;
import paint.Brush;
import paint.Canvas;

public class Test extends Pattern
{
	public Test(Canvas c, Brush[] brushes){
		super(c, brushes);
	}
	
	@Override
	public void draw(){
		Brush b = brushes[0];
		b.setBlendType(BlendType.SUBTRACT);
		b.getBlendType().setDestBlendFactor(0);
		b.getBlendType().setSrcBlendFactor(0);
		b.setColor(0x11111111);
		int cx = canvas.WIDTH / 2;
		int cy = canvas.HEIGHT / 2;
		b.moveTo(cx, cy);
		
		int r = 250;
		int t = 100;
		for(int i = 0; i < 10000; i++)
		{
			double a = Math.toRadians(i);
			double f = 0.2;
			double x = (r - t * Math.sin(a * f)) * Math.cos(a);
			double y = (r - t * Math.cos(a * f)) * Math.sin(a);
			b.moveTo(cx + x, cy + y);
			b.apply(canvas);
		}
	}
}
