package paint;

public class PointBrush implements Applicator<Integer>
{
	int x;
	int y;
	
	public PointBrush()
	{
		this.x = 0;
		this.y = 0;
	}

	@Override
	public void apply(Bitmap<Integer> b)
	{
		b.setPixel(x, y, 0x0);
	}
	
	public void moveTo(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void applyAlongPath(int dx, int dy, Bitmap<Integer> b)
	{
		while(b.setPixel(x, y, 0x0))
		{
			moveTo(x += dx, y += dy);
		}
	}
}
