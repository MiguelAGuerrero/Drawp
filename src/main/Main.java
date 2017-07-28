package main;
import paint.*;

public class Main
{
	public static void main(String[] args)
	{
		Canvas c = new Canvas(1000);
		c.fill(0x0);
		Brush a = new Brush();
		new Thread(new Spiral(c, a)).start();
	}
}
