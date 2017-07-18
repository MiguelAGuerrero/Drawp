package paint;

public class PixmapConverter {
	
	int[][] pixmap;
	
	public PixmapConverter(Canvas c){
		this.pixmap = c.getPixels();
	}
	
	public PixmapConverter(int[][] pixmap){
		this.pixmap = pixmap;
	}
	
	public boolean toBitmap32(){
		
		return false;
	}
}
