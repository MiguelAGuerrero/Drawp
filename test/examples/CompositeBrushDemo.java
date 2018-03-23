package examples;

import java.awt.image.BufferedImage;

import drawp.CompositeParticleBrush;
import drawp.DrawpSystem;
import drawp.ParticleBrush;
import paint.Brush;
import paint.PaintCanvas;
import particle.Particle;

public class CompositeBrushDemo extends DrawpSystem
{

	public CompositeBrushDemo(PaintCanvas c, Brush[] brushes)
	{
		super(c, brushes);
		CompositeParticleBrush cpb = new CompositeParticleBrush(this.particleBrushes.get(0));
		
		this.particleBrushes.get(0).setVelocityX(1);
		this.particleBrushes.add(cpb);
		this.system.registerParticle(cpb);
		
		cpb.setVelocity(0, -1);
		cpb.setLocation(250, 250);
	}
	
	
	@Override
	public BufferedImage getImage()
	{
		return this.canvas.getImage();
	}

}
