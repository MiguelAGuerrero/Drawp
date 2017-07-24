package paint;

/**
 * Canvas represents a primitive bitmap. It stores pixels as ints in a 2D array data structure,
 * and allows pixels to be assigned and retrieved from the map.
 * @author Miguel Guerrero
 */

public class Canvas {
	public final int WIDTH;
	public final int HEIGHT;
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
	
	public int getPixel(int x, int y){
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
		for(int i = 0; i < pixmap.length; i++){
			for(int j = 0; j < pixmap[0].length; j++){
				pixmap[i][j] = pixel;
			}
		}
	}
}
