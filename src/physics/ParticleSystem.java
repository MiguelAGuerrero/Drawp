package physics;

import java.util.TreeSet;

public class ParticleSystem
{
	private TreeSet<Particle> particles;
	
	public ParticleSystem()
	{
		particles = new TreeSet<>();
	}
	
	public void registerParticle(Particle p)
	{
		particles.add(p);
	}
	
	public void removeParticle(Particle p)
	{
		particles.remove(p);
	}
	
	public void update()
	{
		particles.forEach(particle -> particle.move());
	}
}
