package paint;

public interface Blender<T>
{
	/***
	 * The Blender interface contracts implementors
	 * to derive a value from two values of the same type.
	 * @param base
	 * @param blend 
	 * @return A value derived from an operation performed on the base and the blend
	 */
	
	T blend(T base, T blend);
}
