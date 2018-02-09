package examples;

import java.awt.image.BufferedImage;

import drawp.DrawpSystem;
import paint.Brush;
import paint.PaintCanvas;

public class CompositeBrushDemo extends DrawpSystem
{

	public CompositeBrushDemo(PaintCanvas c, Brush[] brushes)
	{
		super(c, brushes);
	}

	@Override
	public BufferedImage getImage() {
		return this.canvas.getImage();
	}

}
