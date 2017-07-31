package paint;

public class PointBrush extends Brush
{
	@Override
	public void apply(Bitmap<Integer> b)
	{
		b.setPixel((int) x, (int) y, color);
	}
}
