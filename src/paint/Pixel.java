package paint;

import java.awt.Color;

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
	public static int getRValue(int packedARGBVal){ return (packedARGBVal & MASK_RED) 	>>> RED_BITPOSITION;}
	public static int getGValue(int packedARGBVal){ return (packedARGBVal & MASK_GREEN) >>> GREEN_BITPOSITION;}
	public static int getBValue(int packedARGBVal){ return (packedARGBVal & MASK_BLUE);}
	
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
	
	public Pixel(int r, int g, int b, int a)
	{
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	
	public int toInt()
	{
		return pack(a, r, g, b);
	}
	
	public static int pack(int a, int r, int g, int b)
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
	
	public static Pixel valueOf(int pixel)
	{
		return new Pixel(pixel);
	}
	
	public static int toGrayscale(int pixel)
	{
		int avg = avgRGBValue(pixel);
		int pixelInGrayscale = pack(getAValue(pixel), avg, avg, avg);
		return pixelInGrayscale;
	}
	
	public static int avgRGBValue(int pixel)
	{
		//Get separate RGB values
		int r = getRValue(pixel);
		int g = getGValue(pixel);
		int b = getBValue(pixel);
		
		//Compute the average and form a
		//new pixel where each value is the average
		//to form a grayscale
		return (r + g + b)  / 3;		
	}
	
	public boolean equals(Pixel p)
	{
		if(this.a == p.a 
			&& this.r == p.r
			&& this.g == p.g 
			&& this.b == p.b)
		{
			return true;
		}
		
		return false;
		
	}
	
}
