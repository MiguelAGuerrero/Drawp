package particle;

import java.awt.geom.Point2D;

public class Particle extends Point2D
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
		
		public double getVelocityX() {
			return velX;
		}

		public void setVelocityX(double velX) {
			this.velX = velX;
			setAngleWithRespectToVelocity();
		}

		public double getVelocityY() {
			return velY;
		}

		public void setVelocityY(double velY) {
			this.velY = velY;
			setAngleWithRespectToVelocity();
		}

		public void setVelocity(double dx, double dy)
		{
			this.velX = dx;
			this.velY = dy;
			setAngleWithRespectToVelocity();
		}
		
		private void setAngleWithRespectToVelocity() {
			angle = calculateAngleFromVelocities();
		}

		public double getAccelerationX() {
			return accelX;
		}

		public void setAccelerationX(double accelX) {
			this.accelX = accelX;
		}

		public double getAccelerationY() {
			return accelY;
		}

		public void setAccelerationY(double accelY) {
			this.accelY = accelY;
		}

		public void setAcceleration(double accelX, double accelY)
		{
			setAccelerationX(accelX);
			setAccelerationY(accelY);
		}
		
		public boolean isAccelerating()
		{
			return this.accelX != 0 && this.accelY !=0;
		}
		
		public double getAngle()
		{
			return angle;
		}

		public void setAngle(double angle)
		{
			this.angle = angle;
			setVelocitiesWithRespectToAngle();
		}
		
		private void setVelocitiesWithRespectToAngle()
		{
			double speed = getSpeed();
			this.velX = speed * Math.cos(Math.toRadians(angle));
			this.velY = speed * Math.sin(Math.toRadians(angle));
		}
		
		public double getSpeed()
		{
			return Math.hypot(velX, velY);
		}
		
		public double getAngularVelocity() {
			return angularVelocity;
		}

		public void setAngularVelocity(double angularVelocity)
		{
			this.angularVelocity = angularVelocity;
		}

		public double getAngularAcceleration()
		{
			return angularAcceleration;
		}

		public void setAngularAcceleration(double angularAcceleration)
		{
			this.angularAcceleration = angularAcceleration;
		}

		public void move()
		{
			applyAngularChangesToVelocities();
			displace();
			applyAcceleration();
		}
		
		
		private void applyAngularChangesToVelocities()
		{
			if(this.angularVelocity > 0 || this.angularAcceleration > 0)
			{
				angle += angularVelocity;
				angularVelocity += angularAcceleration;
				setVelocitiesWithRespectToAngle();
			}
		}
		
		private void displace()
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

		//TODO: Implement this using the physical state of the particle
		public String toString()
		{
			return "";
		}

		@Override
		public void setLocation(double x, double y)
		{
			setX(x);
			setY(y);
		}
}
