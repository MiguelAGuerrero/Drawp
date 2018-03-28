package particle;

import java.util.function.BinaryOperator;

public class VectorField implements Force
{
	private BivariateFunction<Double, double[]> bvf;
	private double srcx;
	private double srcy;
	
	public VectorField(
			BivariateFunction<Double, double[]> bvf, 
			double srcx, 
			double srcy)
	{
		this.bvf = bvf;
		this.srcx = srcx;
		this.srcy = srcy;
	}
	
	public void exert(Particle p) 
	{
		double[] vector = bvf.apply(
				p.getX() - srcx,
				p.getY() - srcy);
		
		p.setVelocity(
				(p.getVelocityX() + vector[0]) / 1.2, 
				(p.getVelocityY() + vector[1]) / 1.2);
	}
	
	public void setSource(double x, double y) 
	{
		this.srcx = x;
		this.srcy = y;
	}
	
	public static interface BivariateFunction<t1, t2>
	{
		public t2 apply(t1 fx, t1 fy);
	}
}
