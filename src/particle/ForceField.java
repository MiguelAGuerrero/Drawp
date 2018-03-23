package particle;

public class ForceField extends Particle implements Force
{
	private double forceRange;
	private double strength;
	
	public ForceField(double forceRange, double strength)
	{
		this.strength = strength;
		this.forceRange = forceRange;
	}
	
	@Override
	public void exert(Particle particle)
	{
		//Do not apply the force upon itself
		if(this == particle)
			return;
		
		if(isInRange(particle))
		{
			double dx = this.getX() - particle.getX();
			double dy = this.getY() - particle.getY();
			double magnitude = Math.hypot(dx, dy);
			particle.setLocation(
					particle.getX() + strength * dx / magnitude, 
					particle.getY() + strength * dy / magnitude);
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
