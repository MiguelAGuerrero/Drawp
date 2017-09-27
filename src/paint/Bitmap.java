package paint;

/**
 * The Bitmap interfaces contracts its implementors to manage pixel data. 
 * @author Miguel Guerrero
 * @param <T> Type representation of a pixel
 */
public interface Bitmap<T>
{
	boolean setPixel(int x, int y, T pixel);
	T getPixel(int x, int y);
}
