package paint;

/**
 * A utility class that can unpack and manipulate pixel data that are represented as 32-bit integers.
 * @author Miguel Guerrero
 */
public class Pixel
{
	public static int ALPHA_BITPOSITION = 24;
	public static int MASK_ALPHA = 0xFF000000;
	
	public static int RED_BITPOSITION = 16;
	public static int MASK_RED = 0x00FF0000;
	
	public static int GREEN_BITPOSITION = 8;
	public static int MASK_GREEN = 0x0000FF00;

	public static int BLUE_BITPOSITION = 0;
	public static int MASK_BLUE = 0x000000FF;
	
	public static int getAValue(int packedARGBVal){ return (packedARGBVal & MASK_ALPHA) >>> ALPHA_BITPOSITION;}
	public static int getRValue(int packedARGBVal){ return (packedARGBVal & MASK_RED) >>> RED_BITPOSITION;}
	public static int getGValue(int packedARGBVal){ return (packedARGBVal & MASK_GREEN) >>> GREEN_BITPOSITION;}
	public static int getBValue(int packedARGBVal){ return (packedARGBVal & MASK_BLUE);}
	
	public int a;
	public int r;
	public int g;
	public int b;
	
	public Pixel(int packedARGBVal)
	{
		this.a = (byte) getAValue(packedARGBVal);
		this.r = (byte) getRValue(packedARGBVal);
		this.g = (byte) getGValue(packedARGBVal);
		this.b = (byte) getBValue(packedARGBVal);
	}
	
	public int toInt()
	{
		return pack(r, g, b, a);
	}
	
	public static int pack(int r, int g, int b, int a)
	{
		return a << ALPHA_BITPOSITION 
				| r << RED_BITPOSITION
				| g << GREEN_BITPOSITION
				| b;
	}
	
	public String toString()
	{
		return  "R: " + "G: " + g + "B: " + b + "A: " + a;
	}
}
