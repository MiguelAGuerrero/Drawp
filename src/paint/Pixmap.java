package paint;

/**
 * The Pixmap interfaces contracts its implementors to manage pixel data represented as ints. 
 * @author Miguel Guerrero
 */
public interface Pixmap
{
	boolean setPixel(int pixel, int x, int y);
	int getPixel(int x, int y);
}
