package examples;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import drawp.DrawpSystem;
import drawp.ParticleBrush;
import paint.Brush;
import paint.PaintCanvas;
import particle.ForceField;
import particle.ParticleSystem;

public class SimpleDemo extends DrawpSystem
{	
	public SimpleDemo(PaintCanvas c, Brush[] brushes)
	{
		super(c, brushes);
		setupParticles();
		addAttractor();
	}
	
	@Override
	public void update()
	{
		system.update();
	}
	
	@Override
	public void draw()
	{
		applyBrushes();
	}
	
	private void addAttractor()
	{
		double radius = 100;
		double strength = -2;
		ForceField a = new ForceField(radius, strength);
		ForceField b = new ForceField(radius, strength);
		a.setLocation(canvas.WIDTH / 2, 2 * canvas.HEIGHT / 3 );
		b.setLocation(canvas.WIDTH / 2, canvas.HEIGHT / 3);
		//b.setVelocity(1, 0);
		system.registerForce(a); 
		system.registerForce(b);
	}
	
	private void applyBrushes()
	{
		for(ParticleBrush pb: particleBrushes)
			pb.apply(canvas);
	}
	
	private void setupParticles()
	{
		int cx = canvas.WIDTH / 2;
		int cy = canvas.HEIGHT / 2;
		int size = particleBrushes.size();
		Iterator<ParticleBrush> itr = particleBrushes.iterator();
		double interval = 2 * Math.PI / size;
		double radius = 10;
		for(int i = 0; i < size; i++)
		{
			ParticleBrush pb = itr.next();
			double angrad = i * interval;
			double cosx = Math.cos(angrad);
			double siny =  Math.sin(angrad);
			pb.setLocation(cx + radius * cosx, cy + radius * siny);
			pb.setVelocity(0, 2);
			pb.setAngle(Math.toDegrees(angrad));
			pb.setAngularVelocity(0.5);
			pb.getBrush().setColor(i * 10000);
		}
	}

	@Override
	public BufferedImage getImage()
	{
		return this.canvas.getImage();
	}	
}
