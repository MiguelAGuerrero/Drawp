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
				Files.newOutputStream(pathOutput, CREATE, TRUNCATE_EXISTING)))
		{
			for(int pixel: canvas)
			{
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

	private void writeHeader(OutputStream out) throws IOException
	{
		byte[] nothing = {0, 0, 0, 0};
		byte[] headerField = {0x42, 0x4D};
		byte[] bmpFileSize = nothing;
		byte[] reservedValues = nothing;
		byte[] pixelArrayStartingAddress = {0, 0, 0, 54};
		byte[] sizeOfHeader = {0, 0, 0, 40};
		byte[] bitmapWidth = {};
		byte[] bitmapHeight = {};
		byte[] numColorPlanes = {0, 1};
		byte[] bitsPerPixel = {0, 24};
		byte[] compressionMethod = nothing;
		byte[] imageSize = {};
		byte[] horizontalResolution = nothing;
		byte[] verticalResolution = horizontalResolution;
		byte[] colorsInPalette = nothing;
		byte[] importantColors = nothing;
		byte[][] headerFields = 
			{
					headerField,
					bmpFileSize,
					reservedValues,
					pixelArrayStartingAddress,
					sizeOfHeader,
					bitmapWidth,
					bitmapHeight,
					numColorPlanes,
					bitsPerPixel,
					compressionMethod,
					imageSize,
					horizontalResolution,
					verticalResolution,
					colorsInPalette,
					importantColors
			};

		for(byte[] fields: headerFields)
		{
			out.write(fields);
		}
	}
}
