package paint;

/**
 * The Bitmap interfaces contracts its implementors to manage pixel data. 
 * @author Miguel Guerrero
 * @param <T> Type representation of a pixel
 */
public interface Bitmap
{
	boolean setPixel(int pixel, int x, int y);
	int getPixel(int x, int y);
}
