package paint;

/**
 * Canvas represents a primitive bitmap. It stores pixels as ints in a 2D array data structure,
 * and allows pixels to be assigned and retrieved from the map.
 * @author Miguel Guerrero
 */

public class Canvas {
	public final int WIDTH;
	public final int HEIGHT;
	public final int[][] pixmap;
	
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
	
	public int getPixel(int x, int y){
		if(inBounds(x, y)){
			return pixmap[x][y];
		}
		
		else return -1;
	}
	
	private boolean inBounds(int x, int y){
		return x >= 0 && x < this.WIDTH && y >= 0 && y < this.HEIGHT;
	}
}
