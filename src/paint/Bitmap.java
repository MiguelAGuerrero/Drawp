package paint;

/**
 * The Bitmap interfaces contracts its implementors to manage pixel data. 
 * @author Miguel Guerrero
 * @param <T> Type representation of a pixel
 */
public interface Bitmap<T>
{
	boolean setPixel(T pixel, int x, int y);
	T getPixel(int x, int y);
}
