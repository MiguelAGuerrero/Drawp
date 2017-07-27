package paint;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Canvas represents a primitive bitmap. 
 * It stores pixels as ints in a 2D array data structure and maps their position 1 : 1
 * to their index in the in 2D array.
 * @author Miguel Guerrero
 */

public class Canvas implements Bitmap<Integer>, Iterable<Integer>
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
	private int[][] pixmap;

	public Canvas(int width, int height)
	{
		this.WIDTH = width;
		this.HEIGHT = height;
		initPixmap();
	}

	private void initPixmap()
	{
		pixmap = new int[WIDTH][HEIGHT];
		fill(0);
	}
	
	/**
	 * Constructs a square canvas with the provided size
	 * @param size The length of the canvas in terms of pixels
	 */
	public Canvas(int size) { this(size, size); }

	public boolean setPixel(int x, int y, Integer pixelData)
	{
		if(inBounds(x, y))
		{
			pixmap[x][y] = pixelData;
			return true;
		}

		else return false;
	}

	public Integer getPixel(int x, int y)
	{
		if(inBounds(x, y)){ return pixmap[x][y]; }
		else return -1;
	}

	public int[][] getPixels(){ return pixmap; }

	private boolean inBounds(int x, int y)
	{
		return x >= 0 && x < this.WIDTH && y >= 0 && y < this.HEIGHT;
	}

	public void fill(Integer pixel)
	{
		for(int[] row : pixmap)
		{
			Arrays.fill(row, pixel);
		}
	}

	@Override
	public Iterator<Integer> iterator(){ return new CanvasIterator(); }

	private class CanvasIterator implements Iterator<Integer>
	{
		private int row = 0;
		private int column = 0;

		@Override
		public boolean hasNext() 
		{
			return row < HEIGHT && column < WIDTH;
		}

		@Override
		public Integer next() 
		{
			Integer pixel = pixmap[row][column];
			moveToNextPosition();
			return pixel;
		}

		private void moveToNextPosition()
		{
			column++;
			if(column == WIDTH)
			{
				column = 0;
				row++;
			}
		}
	}
}
