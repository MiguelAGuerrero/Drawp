package drawp;

import paint.Applicator;
import paint.Pixmap;
import paint.Brush;
import particle.Particle;

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
	public void apply(Pixmap b)
	{
		brush.moveTo(getX(), getY());
		brush.apply(b);
	}
}
