package paint;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.io.*;

public class CanvasToBitmap {
	Canvas canvas;
	public CanvasToBitmap(Canvas c){
		this.canvas = c;
	}
	public boolean convert(String output){
			int[][] pixmap = canvas.getPixels();
			Path pathOutput = Paths.get(output);
		    try(OutputStream out = new BufferedOutputStream(
		  	      Files.newOutputStream(pathOutput, CREATE, APPEND))){
		}
		    
		catch(IOException ioe){
			System.out.print("Error in converting canvas - ");
			System.out.println(ioe);
			return false;
		}
		    
		return true;
	}
	
	private static void s(){
	    String s = "Hello World! ";
	    byte data[] = s.getBytes();
	    Path p = Paths.get("./logfile.txt");

	    try (OutputStream out = new BufferedOutputStream(
	      Files.newOutputStream(p, CREATE, APPEND))) {
	      out.write(data, 0, data.length);
	    } catch (IOException x) {
	      System.err.println(x);
	    }
	  }
}
