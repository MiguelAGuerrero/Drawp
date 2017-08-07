package physics;

public class Particle implements Comparable<Particle>
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

		public void setPosition(double x, double y)
		{
			setX(x);
			setY(y);
		}
		
		public double getVelX() {
			return velX;
		}

		public void setVelX(double velX) {
			this.velX = velX;
			setAngleWithRespectToVelocity();
		}

		public double getVelY() {
			return velY;
		}

		public void setVelY(double velY) {
			this.velY = velY;
			setAngleWithRespectToVelocity();
		}

		public void setVelocity(double x, double y)
		{
			setVelX(x);
			setVelY(y);
			setAngleWithRespectToVelocity();
		}
		
		private void setAngleWithRespectToVelocity() {
			angle = calculateAngleFromVelocities();
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

		public void setAcceleration(double accelX, double accelY)
		{
			setAccelX(accelX);
			setAccelY(accelY);
		}
		
		public double getAngle() {
			return angle;
		}

		public void setAngle(double angle) {
			this.angle = angle;
			setVelocitiesWithRespectToAngle();
		}
		
		private void setVelocitiesWithRespectToAngle()
		{
			double speed = getSpeed();
			this.velX = speed * Math.cos(angle);
			this.velY = speed * Math.sin(angle);
		}
		
		public double getSpeed(){
			return Math.hypot(velX, velY);
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
				setVelocitiesWithRespectToAngle();
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
			double dx = this.getX() - otherParticle.getX();
			double dy = this.getY() - otherParticle.getY();
			double units = dx + dy;
			double origin = 0;
			return Double.compare(units, origin);
		}
		
		//TODO: Implement this using the physical state of the particle
		public String toString()
		{
			return "";
		}
}
