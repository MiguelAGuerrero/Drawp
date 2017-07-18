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
	
	public void setPixel(int x, int y, int pixelData){
		pixmap[x][y] = pixelData;
	}
}
