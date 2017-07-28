package paint;

public class PointBrush extends Brush
{
	@Override
	public void apply(Bitmap<Integer> b)
	{
		b.setPixel(x, y - 1, 0x0);
		b.setPixel(x, y, 0x0);
		b.setPixel(x, y + 1, 0x0);		
	}
}
