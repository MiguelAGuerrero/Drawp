package paint;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.io.*;

public class Bitmap 
{
	Canvas canvas;
	public Bitmap(Canvas c)
	{
		this.canvas = c;
	}
	
	public boolean convert(String output)
	{
			int[][] pixmap = canvas.getPixels();
			Path pathOutput = Paths.get(output);
		    try(OutputStream out = new BufferedOutputStream(
		  	      Files.newOutputStream(pathOutput, CREATE, APPEND)))
		    {
		    	for(int[] row: pixmap)
		    	{
		    		for (int pixel: row)
		    		{
		    			int r = pixel >>> 16;
		    			int g = pixel >>> 8;
		    			int b = (pixel << 24) >>> 24;
		    			out.write(r);
		    			out.write(g);
		    			out.write(b);
		    		}
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
