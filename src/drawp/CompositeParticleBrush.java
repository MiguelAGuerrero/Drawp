package drawp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import paint.Applicator;
import paint.Bitmap;

public class CompositeParticleBrush 
extends ParticleBrush 
implements Iterable<ParticleBrush>
{
	private Collection<ParticleBrush> brushes;
	
	public CompositeParticleBrush(ParticleBrush... brushes)
	{
		this.brushes = new ArrayList<ParticleBrush>();
		for(ParticleBrush b: brushes) { this.brushes.add(b); }
	}

	public void addBrush(ParticleBrush pb)
	{
		this.brushes.add(pb);
	}
	
	public void removeBrush(ParticleBrush pb)
	{
		this.brushes.remove(pb);
	}
	
	@Override
	public void apply(Bitmap<Integer> b)
	{
		for(ParticleBrush pb: brushes) { pb.apply(b); }
	}
	
	public void move()
	{
		super.move();
		
		//Translate particle brushes based on the movement of the 
		//center brush
		for(ParticleBrush pb: brushes)
		{
			pb.setPosition(pb.getX() + getVelocityX(), 
					pb.getY() + getVelocityY());
		}
		
	}
	
	@Override
	public Iterator<ParticleBrush> iterator()
	{
		return brushes.iterator();
	}
}
