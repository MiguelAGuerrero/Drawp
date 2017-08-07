package physics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

public class ParticleSystem
{
	private Collection<Particle> particles;
	private Collection<Force> forces;
	
	public ParticleSystem()
	{
		particles = new TreeSet<>();
		forces = new ArrayList<>();
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
		{
			for(Particle p: particles)
			{
				f.applyForce(p);
			}
		}
	
		for(Particle p: particles) { p.move(); }
	}
}
