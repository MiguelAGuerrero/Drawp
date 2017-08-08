package physics;

public class ForceField extends Particle implements Force
{
	double forceRange;
	double strength;
	
	public ForceField(double forceRange, double strength)
	{
		this.forceRange = forceRange;
		this.strength = strength;
	}
	
	@Override
	public void applyForce(Particle particle)
	{
		if(isInRange(particle))
		{
			boolean above = particle.getY() > this.getY();
			if(above)
			{
				particle.setY(particle.getY() - strength);
			}
			
			else particle.setY(particle.getY() + strength);
			
			boolean onRight = particle.getX() > this.getX();
			if(onRight)
			{
				particle.setX(particle.getX() - strength);
			}
			
			else particle.setX(particle.getX() + strength);
		}
	}

	private boolean isInRange(Particle particle)
	{
		double distX = this.getX() - particle.getX();
		double distY = this.getY() - particle.getY();
		double dist = Math.hypot(distX, distY);
		return dist < forceRange;
	}
}
