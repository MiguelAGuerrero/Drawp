package paint;

import java.util.function.BinaryOperator;

public enum BlendType implements Blender<Integer>
{	
	/**
	 * TODO: Fix the blending algorithm.
	 */
	  NORMAL(  (Integer a, Integer b) -> (a))
	, ADD(     (Integer a, Integer b) -> (a + b) / 2)
	, SUBTRACT((Integer a, Integer b) -> (a - b) / 2)
	, MULTIPLY((Integer a, Integer b) -> a * b / 2);
	
	private final BinaryOperator<Integer> blendFunc;
	private double srcBlendFactor = 1;
	private double destBlendFactor = 1;
	
	BlendType(BinaryOperator<Integer> bop)
	{
		this.blendFunc = bop;
	}
	
	public void setSrcBlendFactor(double blendFactor)
	{
		srcBlendFactor = blendFactor;
	}
	
	public void setDestBlendFactor(double blendFactor)
	{
		destBlendFactor = blendFactor;
	}
	
	public Integer blend(Integer base, Integer blend)
	{
		Pixel p1 = new Pixel(base);
		Pixel p2 = new Pixel(blend);
		int newA = blendFunc.apply((int) srcBlendFactor * p1.a, (int) destBlendFactor * p2.a);
		int newR = blendFunc.apply((int) srcBlendFactor * p1.r, (int) destBlendFactor * p2.r);
		int newG = blendFunc.apply((int) srcBlendFactor * p1.g, (int) destBlendFactor * p2.g);
		int newB = blendFunc.apply((int) srcBlendFactor * p1.b, (int) destBlendFactor * p2.b);
		return Pixel.pack(newA, newR, newG, newB);
	}
}
