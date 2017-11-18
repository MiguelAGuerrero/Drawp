package drawp;

import paint.Applicator;
import paint.Bitmap;
import paint.Brush;
import physics.Particle;

public class ParticleBrush extends Particle implements Applicator
{
	private Brush brush;
	
	public ParticleBrush()
	{
		this.brush = new Brush();
	}
	
	public ParticleBrush(Brush brush)
	{
		this.brush = brush;
	}
	
	@Override
	public void apply(Bitmap b)
	{
		brush.moveTo(getX(), getY());
		brush.apply(b);
	}
}
