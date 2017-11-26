package paint;

public interface Blender<T>
{
	/***
	 * The Blender interface contracts implementors
	 * to derive a value from two values of the same type.
	 * @param src 
	 * @param dest 
	 * @return A value derived from an operation performed on the src and dest
	 */
	
	T blend(T src, T dest);
	void setSrcBlendFactor(double blendFactor);
	void setDestBlendFactor(double blendFactor);
}
