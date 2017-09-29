package paint;

public interface Blender<T>
{
	/***
	 * The Blender interface contracts implementors
	 * to derive a value from two values of the same type.
	 * @param src Value being introduced
	 * @param dest Value that exists
	 * @return A value derived from an operation performed on t1 and t2
	 */
	T blend(T src, T dest);
	public void setSrcBlendFactor(double blendFactor);
	public void setDestBlendFactor(double blendFactor);
}
