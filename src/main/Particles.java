package main;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import paint.Brush;
import paint.Canvas;
import physics.ForceField;
import physics.Particle;
import physics.ParticleSystem;
import java.util.Random;

public class Particles extends Pattern
{
	Collection<ParticleBrush> particleBrushes;
	ParticleSystem system;
	
	public Particles(Canvas c, Brush... brushes)
	{
		super(c, brushes);
		particleBrushes = new LinkedList<>();
		system = new ParticleSystem();
	}

	@Override
	public void draw()
	{
		registerParticleBrushes();
		setupParticles();
		addAttractor();
		int iterations = 1000;
		for(int i = 0; i < iterations; i++)
		{
			system.update();
			applyBrushes();
		}
	}
	
	private void addAttractor()
	{
		double radius = 100;
		double strength = 0;
		ForceField a = new ForceField(radius, strength);
		ForceField b = new ForceField(radius, strength);
		a.setPosition(canvas.WIDTH / 3, canvas.HEIGHT / 2);
		b.setPosition(2 * canvas.WIDTH / 3, canvas.HEIGHT / 2);
		system.registerForce(a);
		system.registerForce(b);
	}
	
	private void registerParticleBrushes()
	{
		for(Brush b: brushes)
		{
			ParticleBrush newParticle = new ParticleBrush(b);
			particleBrushes.add(newParticle);
			system.registerParticle(newParticle);
		}
	}
	
	private void applyBrushes()
	{
		for(ParticleBrush pb: particleBrushes)
		{
			pb.apply(canvas);
		}
	}
	
	private void setupParticles()
	{
		int cx = canvas.WIDTH / 2;
		int cy = canvas.HEIGHT / 2;
		int size = particleBrushes.size();
		Iterator<ParticleBrush> itr = particleBrushes.iterator();
		Random rand = new Random();
		double interval = 360 / size;
		double radius = 100;
		for(int i = 0; i < size; i++)
		{
			ParticleBrush pb = itr.next();
			double cosx = Math.cos(Math.toRadians(i * interval));
			double siny =  Math.sin(Math.toRadians(i * interval));
			pb.setPosition(cx + radius * cosx, cy + radius * siny);
			float f = 0.25f;
			double eo = f + i % 2 * f;
			pb.setVelocity(cosx , siny);
			pb.setAccelX(-1);
			//pb.setAngularVelocity(0.1);
			//pb.setAngularAcceleration(-0.005);
		}
	}
}
