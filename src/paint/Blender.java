package paint;

public interface Blender<T>
{
	public abstract T blend(T appliedPixel, T targetPixel);
}
