package paint;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.io.*;
public class Converter 
{
	private Canvas canvas;

	public Converter(Canvas c){ this.canvas = c; }

	public boolean convert(String output)
	{
		Path pathOutput = Paths.get(output);
		try(OutputStream out = new BufferedOutputStream(
				Files.newOutputStream(pathOutput, CREATE, APPEND)))
		{
			for(int pixel: canvas)
			{
				System.out.println(pixel);
				int r = pixel >>> 16;
				int g = pixel >>> 8;
				out.write(r);
				out.write(g);
				out.write(pixel);
			}
		}

		catch(IOException ioe)
		{
			System.out.print("Error in converting canvas - ");
			System.out.println(ioe);
			return false;
		}

		return true;
	}
}
