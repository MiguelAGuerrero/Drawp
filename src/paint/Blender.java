package paint;

@FunctionalInterface
public interface Blender<T>
{
	/***
	 * The Blender interface is a functional interface. It contracts implementors
	 * to derive a value from two values of the same type.
	 * @param src Value being introduced
	 * @param dest Value that exists
	 * @return A value derived from an operation performed on t1 and t2
	 */
	public abstract T blend(T src, T dest);
}
