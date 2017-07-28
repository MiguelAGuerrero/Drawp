package paint;

public abstract class Brush implements Applicator
{
	int x;
	int y;
	
	public Brush()
	{
		this.x = 0;
		this.y = 0;
	}

	@Override
	public abstract void apply(Bitmap<Integer> b);
	
	public void moveTo(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}
