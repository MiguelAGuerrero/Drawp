package paint;

import java.util.Iterator;

/**
 * Canvas represents a primitive bitmap. It stores pixels as ints in a 2D array data structure,
 * and allows pixels to be assigned and retrieved from the map.
 * @author Miguel Guerrero
 */

public class Canvas implements Bitmap<Integer>, Iterable<Integer>{
	
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
	private final int[][] pixmap;
	
	public Canvas(int width, int height){
		this.WIDTH = width;
		this.HEIGHT = height;
		pixmap = new int[width][height];
	}
	
	public Canvas(int size){
		this.WIDTH = size;
		this.HEIGHT = size;
		pixmap = new int[size][size];
	}
	
	public boolean setPixel(int x, int y, int pixelData){
		if(inBounds(x, y)){
			pixmap[x][y] = pixelData;
			return true;
		}
		
		else return false;
	}
	
	public Integer getPixel(int x, int y){
		if(inBounds(x, y)){
			return pixmap[x][y];
		}
		
		else return -1;
	}
	
	public int[][] getPixels(){
		return pixmap;
	}
	
	public boolean toBitmap(String outputDir){
		
		return true;
	}
	
	private boolean inBounds(int x, int y){
		return x >= 0 && x < this.WIDTH && y >= 0 && y < this.HEIGHT;
	}
	
	public void fill(int pixel)
	{
		for(int p: this){p = pixel;}
	}

	@Override
	public Iterator<Integer> iterator()
	{
		return new CanvasIterator();
	}
	
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
				int pixel = pixmap[row][column];
				moveToNextColumn();
				return pixel;
			}
			
			private void moveToNextColumn()
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
