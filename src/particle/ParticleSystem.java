package particle;

import java.util.ArrayList;
import java.util.Collection;

public class ParticleSystem
{
	private Collection<Particle> particles;
	private Collection<Force> forces;
	
	public ParticleSystem()
	{
		particles = new ArrayList<>();
		forces = new ArrayList<>();
	}
	
	public Collection<Particle> getParticles()
	{
		return this.particles;
	}
	
	public Collection<Force> getForces()
	{
		return this.forces;
	}
	
	public void registerParticle(Particle p)
	{
		particles.add(p);
	}
	
	public void removeParticle(Particle p)
	{
		particles.remove(p);
	}
	
	public void registerForce(Force f)
	{
		forces.add(f);
	}
	
	public void removeForce(Force f)
	{
		forces.remove(f);
	}
	
	public void update()
	{
		for(Force f: forces)
			for(Particle p: particles)
				f.exert(p);
		
		for(Particle p: particles)
			p.move();
	}
}
