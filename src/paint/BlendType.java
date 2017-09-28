package paint;

import java.util.function.BinaryOperator;

public enum BlendType implements Blender<Integer>
{
	/**TODO: So, blending factors are standard. I have not determined where
	 * to add them yet. My thoughts are as followed.
	 * ---- int pixels should not determine the factor
	 * ---- factors should be determined by entities in persistent interaction
	 * ----------- Canvas / Brushes
	 * 
	 * With the canvas / brush relationship, I suppose it would not be hard
	 * to conceive that canvas.blendFactor and brush.blendFactor
	 * 
	 * However, that said, blend() only retrieves two inputs of type T, so somehow these
	 * factors have to be introduced within the code
	 * 
	 * Alternatively, I could modify blend() to accept blending factors, perhaps as a default
	 * method
	**/
	
	/**
	 * TODO: Fix the blending algorithm. They do not work. Noticed that values can overflow 
	 * over 255, creating representation issues.
	 */
	ADD((Integer a, Integer b) 		  -> { return a + b; })
	, SUBTRACT((Integer a, Integer b) -> { return a - b; })
	, MULTIPLY((Integer a, Integer b) -> { return a * b; });
	
	private final BinaryOperator<Integer> bop;
	
	BlendType(BinaryOperator<Integer> bop)
	{
		this.bop = bop;
	}
	
	public Integer blend(Integer srcPixelData, Integer destPixelData)
	{
		Pixel p1 = new Pixel(srcPixelData);
		Pixel p2 = new Pixel(destPixelData);
		int newA = bop.apply(p1.a, p2.a);
		int newR = bop.apply(p1.r, p2.r);
		int newG = bop.apply(p1.g, p2.g);
		int newB = bop.apply(p1.b, p2.b);
		return Pixel.pack(newR, newG, newB, newA);
	}
}
