package paint;

public interface Applicator<T>
{
	void apply(Bitmap<T> b);
}
