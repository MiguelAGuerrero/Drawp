package drawp;

import java.util.ArrayList;
import java.util.Collection;

import paint.Applicator;
import paint.Bitmap;

public class ParticleBrushGroup implements Applicator 
{
	Collection<ParticleBrush> brushes;
	
	public ParticleBrushGroup(ParticleBrush... brushes)
	{
		this.brushes = new ArrayList<ParticleBrush>();
		for(ParticleBrush b: brushes) 
			this.brushes.add(b);
	}
	
	@Override
	public void apply(Bitmap<Integer> b)
	{
		for(ParticleBrush pb: brushes)
		{
			pb.apply(b);
		}
	}
}
