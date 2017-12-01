package paint;

import java.util.function.BinaryOperator;

public enum BlendType implements Blender<Integer>
{	
	/**
	 * TODO: Fix the blending algorithm. They do not work. Noticed that values can overflow 
	 * over 255, creating representation issues.
	 */
	  ADD(     (Integer a, Integer b) -> (a + b) / 2)
	, SUBTRACT((Integer a, Integer b) -> (a - b) / 2)
	, MULTIPLY((Integer a, Integer b) -> a * b);
	
	private final BinaryOperator<Integer> bop;
	private double srcBlendFactor;
	private double destBlendFactor;
	
	BlendType(BinaryOperator<Integer> bop)
	{
		this.bop = bop;
	}
	
	public void setSrcBlendFactor(double blendFactor)
	{
		srcBlendFactor = blendFactor;
	}
	
	public void setDestBlendFactor(double blendFactor)
	{
		destBlendFactor = blendFactor;
	}
	
	public Integer blend(Integer srcPixelData, Integer destPixelData)
	{
		Pixel p1 = new Pixel(srcPixelData);
		Pixel p2 = new Pixel(destPixelData);
		int newA = bop.apply((int) srcBlendFactor * p1.a, (int) destBlendFactor * p2.a);
		int newR = bop.apply((int) srcBlendFactor * p1.r, (int) destBlendFactor * p2.r);
		int newG = bop.apply((int) srcBlendFactor * p1.g, (int) destBlendFactor * p2.g);
		int newB = bop.apply((int) srcBlendFactor * p1.b, (int) destBlendFactor * p2.b);
		return Pixel.pack(newA, newR, newG, newB);
	}
}
