package physics;

public class Particle implements Kinetic, Comparable<Particle>
{
		private double x;
		private double y;
		private double velX;
		private double velY;
		private double accelX;
		private double accelY;
		
		private double angle;
		private double angularVelocity;
		private double angularAcceleration;
		
		public double getX() {
			return x;
		}

		public void setX(double x) {
			this.x = x;
		}

		public double getY() {
			return y;
		}

		public void setY(double y) {
			this.y = y;
		}

		public double getVelX() {
			return velX;
		}

		public void setVelX(double velX) {
			this.velX = velX;
		}

		public double getVelY() {
			return velY;
		}

		public void setVelY(double velY) {
			this.velY = velY;
		}

		public double getAccelX() {
			return accelX;
		}

		public void setAccelX(double accelX) {
			this.accelX = accelX;
		}

		public double getAccelY() {
			return accelY;
		}

		public void setAccelY(double accelY) {
			this.accelY = accelY;
		}

		public double getAngle() {
			return angle;
		}

		public void setAngle(double angle) {
			this.angle = angle;
		}

		public double getAngularVelocity() {
			return angularVelocity;
		}

		public void setAngularVelocity(double angularVelocity) {
			this.angularVelocity = angularVelocity;
		}

		public double getAngularAcceleration() {
			return angularAcceleration;
		}

		public void setAngularAcceleration(double angularAcceleration) {
			this.angularAcceleration = angularAcceleration;
		}

		@Override
		public void move()
		{
			applyAngularChangesToVelocities();
			displaceParticle();
			applyAcceleration();
		}
		
		private void applyAngularChangesToVelocities()
		{
			if(this.angularAcceleration > 0)
			{
				angle += angularVelocity;
				angularVelocity += angularAcceleration;
			}
		}
		private void displaceParticle()
		{
			this.x += velX;
			this.y += velY;
		}
		
		private void applyAcceleration()
		{
			this.velX += accelX;
			this.velY += accelY;
		}
		
		private double calculateAngleFromVelocities()
		{
			return Math.atan2(velX, velY);
		}

		@Override
		public int compareTo(Particle otherParticle)
		{
			double dx = this.x - otherParticle.x;
			double dy = this.y - otherParticle.y;
			double units = dx + dy;
			double origin = 0;
			return Double.compare(units, origin);
		}
}
