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

public class Particles extends DrawpSystem
{
	private Collection<ParticleBrush> particleBrushes;
	private ParticleSystem system;
	
	public Particles(PaintCanvas c, Brush[] brushes, int iterations)
	{
		super(c, brushes, iterations);
		initParticleSystem();
		registerParticleBrushes();
		setupParticles();
		addAttractor();
	}
	
	private void initParticleSystem()
	{
		this.particleBrushes = new ArrayList<>();
		this.system = new ParticleSystem();
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
		double radius = 1000;
		double strength = -0.1;
		ForceField a = new ForceField(radius, strength);
		ForceField b = new ForceField(100, -100);
		a.setPosition(canvas.WIDTH / 2, canvas.HEIGHT / 2);
		b.setPosition(canvas.WIDTH / 2, canvas.HEIGHT / 2);
		b.setAngularVelocity(1);
		b.setVelocity(10, 0);
		//system.registerForce(a); 
		//system.registerForce(b); 

	}
	
	private void registerParticleBrushes()
	{
		for(Brush b: brushes)
		{
			ParticleBrush pb = new ParticleBrush(b);
			particleBrushes.add(pb);
			system.registerParticle(pb);
		}
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
		double radius = 100;
		for(int i = 0; i < size; i++)
		{
			ParticleBrush pb = itr.next();
			double angrad = i * interval;
			double cosx = Math.cos(angrad);
			double siny =  Math.sin(angrad);
			pb.setPosition(cx + radius * cosx, cy + radius * siny);
			pb.setVelocity(0.2, 0);
			pb.setAngle(Math.toDegrees(angrad));
			pb.setAngularVelocity(0.1);
		}
	}

	@Override
	public BufferedImage getImage()
	{
		return this.canvas.getImage();
	}	
}
