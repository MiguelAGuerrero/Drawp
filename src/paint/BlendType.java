package paint;

import java.util.function.BinaryOperator;

public enum BlendType implements Blender<Integer>
{	
	/**
	 * TODO: Fix the blending algorithm. They do not work. Noticed that values can overflow 
	 * over 255, creating representation issues.
	 */
	  ADD((Integer a, Integer b)      -> { return (int) clamp(a + b, 0, 255); })
	, SUBTRACT((Integer a, Integer b) -> { return (int) clamp(a - b, 0, 255); })
	, MULTIPLY((Integer a, Integer b) -> { return (int) clamp(a * b, 0, 255); });
	
	private final BinaryOperator<Integer> bop;
	private double srcBlendFactor;
	private double destBlendFactor;
	
	BlendType(BinaryOperator<Integer> bop)
	{
		this.bop = bop;
	}
	
	public void setSrcBlendFactor(double blendFactor)
	{
		srcBlendFactor = clamp(blendFactor, 0, 1);
	}
	
	public void setDestBlendFactor(double blendFactor)
	{
		destBlendFactor = clamp(blendFactor, 0, 1);
	}
	
	private static double clamp (double val, double lowerBound, double upperBound)
	{
		if(val < lowerBound) return lowerBound;
		if(val > upperBound) return upperBound;
		return val;
	}
	
	public Integer blend(Integer srcPixelData, Integer destPixelData)
	{
		Pixel p1 = new Pixel(srcPixelData);
		Pixel p2 = new Pixel(destPixelData);
		int newA = bop.apply((int) srcBlendFactor * p1.a, (int) destBlendFactor * p2.a);
		int newR = bop.apply((int) srcBlendFactor * p1.r, (int) destBlendFactor * p2.r);
		int newG = bop.apply((int) srcBlendFactor * p1.g, (int) destBlendFactor * p2.g);
		int newB = bop.apply((int) srcBlendFactor * p1.b, (int) destBlendFactor * p1.b);
		return Pixel.pack(newR, newG, newB, newA);
	}
}
