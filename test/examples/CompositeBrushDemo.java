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
		CompositeParticleBrush cpb = new CompositeParticleBrush();
		for(ParticleBrush pb: this.particleBrushes) 
		{
			cpb.addBrush(pb);
		}
		
		this.system.registerParticle(cpb);
		int i = 0;
		for(Particle p: this.particleBrushes) 
		{
			i++;
			p.setAngle(i * 10);
			p.setLocation(250, 250);
			p.setVelocity(0, 1);
		}
		
		cpb.setVelocity(0, -1);
		cpb.setLocation(250, 250);
	}
	
	
	@Override
	public BufferedImage getImage(){
		return this.canvas.getImage();
	}

}
