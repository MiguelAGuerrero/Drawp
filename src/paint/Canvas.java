package paint;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

import javax.imageio.ImageIO;

/**
 * Canvas represents a primitive bitmap. 
 * Stores pixels as primitive integers in a 2D array, whose position is 1 : 1
 * to their index in the array.
 * @author Miguel Guerrero
 */

public class Canvas implements Bitmap
{

	/**
	 * Width of the Canvas
	 */
	public final int WIDTH;

	/**
	 * Height of the canvas
	 */
	public final int HEIGHT;

	/**
	 * Storage container for the pixels of the canvas
	 */
	private BufferedImage pixmap;
	
	public Canvas(int width, int height)
	{
		this.WIDTH = width;
		this.HEIGHT = height;
		initPixmap();
	}

	private void initPixmap()
	{
		pixmap = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		fill(0xFFFFFFFF);
	}
	
	/**
	 * Constructs a square canvas with the provided size
	 * @param size The length of the canvas in terms of pixels
	 */
	public Canvas(int size) { this(size, size); }

	public boolean setPixel(int pixelData, int x, int y)
	{
		if(inBounds(x, y))
		{
			pixmap.setRGB(x, y, pixelData);
			return true;
		}

		else return false;
	}

	public int getPixel(int x, int y)
	{
		if(inBounds(x, y)) 
			return pixmap.getRGB(x, y);
		return -1;
	}

	public int[] getPixels(){ return pixmap.getRGB(0, 0, WIDTH, HEIGHT, null, 0, 1); }

	private boolean inBounds(int x, int y)
	{
		return x >= 0 
				&& x < this.WIDTH 
				&& y >= 0 
				&& y < this.HEIGHT;
	}

	public void fill(int pixel)
	{
		for(int i = 0; i < WIDTH; i++)
			for(int j = 0; j < HEIGHT; j++)
				this.pixmap.setRGB(i, j, pixel);
	}
	
	public void save(String path)
	{
		try 
		{
			ImageIO.write(pixmap, "jpeg", new File(path + ".jpg"));
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
