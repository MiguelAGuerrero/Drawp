package paint;

public interface Blender<T>
{
	public abstract T blend(T applied, T target);
}
