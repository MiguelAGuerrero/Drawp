package drawp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import paint.Brush;
import paint.Canvas;
import physics.ForceField;
import physics.ParticleSystem;

public class Particles extends DrawpSystem
{
	private Collection<ParticleBrush> particleBrushes;
	private ParticleSystem system;
	
	public Particles(Canvas c, Brush[] brushes, int frames)
	{
		super(c, brushes, frames);
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
	public void draw()
	{
		system.update();
		applyBrushes();
	}
	
	private void addAttractor()
	{
		double radius = 200;
		double strength = 2;
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
			ParticleBrush pb = new ParticleBrush(b);
			particleBrushes.add(pb);
			system.registerParticle(pb);
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
		double interval = 360 / size;
		double radius = 50;
		for(int i = 0; i < size; i++)
		{
			ParticleBrush pb = itr.next();
			double angrad = Math.toRadians(i * interval);
			double cosx = Math.cos(angrad);
			double siny =  Math.sin(angrad);
			pb.setPosition(cx + radius * cosx, cy + radius * siny);
			pb.setVelocity(0.5, 0);
			pb.setAngle(Math.toDegrees(angrad));
			pb.setAngularAcceleration(0.005);
		}
	}
	
}
