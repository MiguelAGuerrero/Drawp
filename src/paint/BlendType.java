package paint;

import java.util.function.BinaryOperator;

public enum BlendType implements Blender<Integer>
{	
	/**
	 * TODO: Fix the blending algorithm.
	 */
	  NORMAL(  (Integer a, Integer b) -> (a))
	, ADD(     (Integer a, Integer b) -> (a + b) / 2)
	, SUBTRACT((Integer a, Integer b) -> clamp((a - b) / 2, 0, 255))
	, MULTIPLY((Integer a, Integer b) -> clamp((a * b / 2), 0, 255));
	
	private final BinaryOperator<Integer> blendFunc;
	
	BlendType(BinaryOperator<Integer> bop)
	{
		this.blendFunc = bop;
	}

	public Integer blend(Integer base, Integer blend)
	{
		int newA = blendFunc.apply(Pixel.getAValue(base), Pixel.getAValue(blend));
		int newR = blendFunc.apply(Pixel.getRValue(base), Pixel.getRValue(blend));
		int newG = blendFunc.apply(Pixel.getGValue(base), Pixel.getGValue(blend));
		int newB = blendFunc.apply(Pixel.getBValue(base), Pixel.getBValue(blend));
		return Pixel.pack(newA, newR, newG, newB);
	}
	
	private static Integer clamp(int num, int lowerBound, int upperBound)
	{
		if(num > upperBound) 
			return upperBound;
		else if(num < lowerBound) 
			return lowerBound;
		else return num;
	}
}
