package paint;

public interface BrushShape extends Iterable<ApplicationPoint>
{
	public void setApplicationPoint(int x, int y);
	public void setApplicationPoint(ApplicationPoint ap);
	public void setApplicationPoint(int x, int y, int intensity);
}
