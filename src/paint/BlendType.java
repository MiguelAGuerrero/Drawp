package paint;

import java.util.function.BinaryOperator;

public enum BlendType implements Blender<Integer>
{
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
