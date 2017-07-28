package main;
import paint.*;

public class Main {
	public static void main(String[] args)
	{
		Canvas c = new Canvas(1000);
		Brush a = new Brush();
		boolean[][] shape = {{true}, {true}, {true}, {true}, {true}, {true}, {true}};
		a.setShape(shape);
		new Thread(new Spiral(c, a)).start();
	}
}
