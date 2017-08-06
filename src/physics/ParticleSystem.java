package physics;

import java.util.ArrayList;

public abstract class ParticleSystem
{
	ArrayList<Particle> particles;
	public void registerParticle(Particle p){}
	public void removeParticle(Particle p){}
	public abstract void update();
}
