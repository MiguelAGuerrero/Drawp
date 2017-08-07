package physics;

public class Attractor extends Particle implements Force
{
	int forceRange;
	int strength;
	
	public Attractor(int forceRange, int strength)
	{
		this.forceRange = forceRange;
		this.strength = strength;
	}
	
	@Override
	public void applyForce(Particle particle)
	{
		if(isInRange(particle))
		{
			if(particle.getY() > this.getY())
			{
				particle.setY(particle.getY() - strength);
			}
			
			else particle.setY(particle.getY() + strength);
			
			if(particle.getX() > this.getX())
			{
				particle.setX(particle.getX() - strength);
			}
		}
	}
	
	private boolean isInRange(Particle particle)
	{
		double distX = Math.abs(this.getX() - particle.getX());
		double distY = Math.abs(this.getY() - particle.getY());
		if(distX > forceRange || distY > forceRange) { return false; } 
		else return true;
	}
}
