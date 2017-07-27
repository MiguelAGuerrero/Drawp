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
			writeHeader(out);
			for(int pixel: canvas)
			{
				int r = pixel >>> 16;
				int g = pixel >>> 8;
				out.write(r);
				out.write(g);
				out.write(pixel);
				out.write(0);
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

	private byte[] intToByteArray(int val)
	{
		byte[] byteArr = {(byte) val, (byte) (val >>> 8), (byte) (val >>> 16), (byte) (val >>> 24)};
		return byteArr;
	}
	
	private void writeHeader(OutputStream out) throws IOException
	{
		byte[] nothing = {0, 0, 0, 0};
		byte[] fileHeader = {0x42, 0x4D};
		
		int bytesPerPixel = 4;
		int headerOverhead = 54;
		int rawData = canvas.WIDTH * canvas.HEIGHT * bytesPerPixel;
		int fileSize = rawData + headerOverhead;
		byte[] bmpFileSize = intToByteArray(fileSize);
		byte[] reservedValues = nothing;
		byte[] pixelArrayStartingAddress = {54, 0, 0, 0};
		byte[] sizeOfHeader = {40, 0, 0, 0};
		byte[] bitmapWidth = intToByteArray(canvas.WIDTH);
		byte[] bitmapHeight = intToByteArray(canvas.HEIGHT);
		byte[] numColorPlanes = {1, 0};
		byte[] bitsPerPixel = {24, 0};
		byte[] compressionMethod = nothing;
		byte[] imageSize = intToByteArray(rawData);
		byte[] horizontalResolution = {35, 28, 0, 0};
		byte[] verticalResolution = horizontalResolution;
		byte[] colorsInPalette = nothing;
		byte[] importantColors = nothing;
		byte[][] headerFields = 
			{
					fileHeader,
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
