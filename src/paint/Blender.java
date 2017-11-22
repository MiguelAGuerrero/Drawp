package paint;

public interface Blender<T>
{
	/***
	 * The Blender interface contracts implementors
	 * to derive a value from two values of the same type.
	 * @param srcA Source 1
	 * @param srcB Source 2
	 * @return A value derived from an operation performed on t1 and t2
	 */
	
	T blend(T srcA, T srcB);
	void setSrcBlendFactor(double blendFactor);
	void setDestBlendFactor(double blendFactor);
}
