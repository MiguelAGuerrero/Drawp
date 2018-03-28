package examples;

import java.awt.image.BufferedImage;

import drawp.CompositeParticleBrush;
import drawp.DrawpSystem;
import drawp.ParticleBrush;
import paint.Brush;
import paint.PaintCanvas;

public class CompositeBrushDemo extends DrawpSystem
{

	public CompositeBrushDemo(PaintCanvas c, Brush[] brushes)
	{
		super(c, brushes);
		CompositeParticleBrush cpb = new CompositeParticleBrush(this.particleBrushes.get(0));
		
		ParticleBrush example = this.particleBrushes.get(0);
		example.setVelocityX(3);
		example.setLocation(250, 250);
		example.setAngularVelocity(3);
		
		this.particleBrushes.add(cpb);
		this.system.registerParticle(cpb);
		
		cpb.setVelocity(0, -0.5);
		cpb.setLocation(250, 250);
		cpb.setAngularVelocity(0.5);
	}
	
	
	@Override
	public BufferedImage getImage()
	{
		return this.canvas.getImage();
	}

}
