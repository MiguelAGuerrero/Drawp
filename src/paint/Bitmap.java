package paint;

public interface Bitmap<T>
{
	boolean setPixel(int x, int y, int p);
	T getPixel(int x, int y);
}
