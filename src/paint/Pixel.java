package paint;

/**
 * A utility class that can unpack and manipulate pixel data that are represented as 32-bit integers.
 * @author Miguel Guerrero
 */
public class Pixel
{
	public static int ALPHA_BITPOSITION = 24;
	public static int BITMASK_ALPHA = 0xFF000000;
	
	public static int RED_BITPOSITION = 16;
	public static int BITMASK_RED = 0x00FF0000;
	
	public static int GREEN_BITPOSITION = 8;
	public static int BITMASK_GREEN = 0x0000FF00;

	public static int BLUE_BITPOSITION = 0;
	public static int BITMASK_BLUE = 0x000000FF;
	
	public static int getAValue(int packedARGBVal){ return (packedARGBVal & BITMASK_ALPHA) >>> ALPHA_BITPOSITION;}
	public static int getRValue(int packedARGBVal){ return (packedARGBVal & BITMASK_RED) >>> RED_BITPOSITION;}
	public static int getGValue(int packedARGBVal){ return (packedARGBVal & BITMASK_GREEN) >>> GREEN_BITPOSITION;}
	public static int getBValue(int packedARGBVal){ return (packedARGBVal & BITMASK_BLUE);}
	
	public int a;
	public int r;
	public int g;
	public int b;
	
	public Pixel(int packedARGBVal)
	{
		this.a = getAValue(packedARGBVal);
		this.r = getRValue(packedARGBVal);
		this.g = getGValue(packedARGBVal);
		this.b = getBValue(packedARGBVal);
	}
	
	public int toInt()
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
