package paint;

public class PointBrush implements Applicator<Integer>
{
	int x;
	int y;
	
	public PointBrush(){}

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
}
