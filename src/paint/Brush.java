package paint;

public class Brush implements Applicator
{
	protected int x;
	protected int y;
	protected int color = 0x0;
	protected boolean[][] shape;
	
	public Brush()
	{
		this.x = 0;
		this.y = 0;
		this.shape = new boolean[1][1];
		shape[0][0] = true;
	}

	@Override
	public void apply(Bitmap<Integer> b)
	{
		int shapeCX = shape.length / 2;
		int shapeCY = shape[0].length / 2;
		
		for(int i = 0; i < shape.length; i++)
		{
			for(int j = 0; j < shape[i].length; j++)
			{
				boolean pointOfApplication = shape[i][j];
				if(pointOfApplication)
					b.setPixel(x + shapeCX - i, y + shapeCY - j, color);
			}
		}
	}
	
	public void moveTo(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void setColor(int color)
	{
		this.color = color;
	}
	
	public int getColor()
	{
		return color;
	}

	public void setShape(boolean[][] shape2) {
		this.shape = shape2;
	}
}
