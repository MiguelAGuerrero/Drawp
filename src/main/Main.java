package main;
import paint.*;

public class Main {
	public static void main(String[] args)
	{
		Canvas c = new Canvas(1000);
		Brush a = new PointBrush();
		new Thread(new Spiral(c, a)).start();
	}
}
