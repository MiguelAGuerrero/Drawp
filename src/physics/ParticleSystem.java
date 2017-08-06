package physics;

import java.util.TreeSet;

public class ParticleSystem
{
	TreeSet<Particle> particles;
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
		particles.forEach(action -> action.move());
	}
}
