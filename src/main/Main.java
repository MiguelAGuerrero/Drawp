package main;
import paint.*;

public class Main {
	public static void main(String[] args)
	{
		Canvas c = new Canvas(1000);
		Applicator<Integer> a = new PointBrush();
		int x = 0;
		int y = 0;
		double ang = 0;
		double radius = 0;
		
		while(c.setPixel(x, y, 0x0))
		{
			double rad = Math.toRadians(ang);
			x = (int) (500 + radius * Math.cos(rad));
			y = (int) (500 + radius * Math.sin(rad));
			System.out.printf("X:%d, Y%d\n", x, y);
			ang += 1;
			radius += 0.05;
		}

		x = 0;
		y = 0;
		ang = 0;
		radius = 0;
		
		while(c.setPixel(x, y, 0x0))
		{
			double rad = Math.toRadians(ang);
			x = (int) (500 - radius * Math.cos(rad));
			y = (int) (500 - radius * Math.sin(rad));
			System.out.printf("X:%d, Y%d\n", x, y);
			ang += 1;
			radius += 0.05;
		}
		
		Converter co = new Converter(c);
		co.convert("test.bmp");
	}
}
