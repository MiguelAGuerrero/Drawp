package drawp;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import paint.Brush;
import paint.PaintCanvas;
import particle.ParticleSystem;

public abstract class DrawpSystem implements Runnable
{
	protected PaintCanvas canvas;
	protected ArrayList<ParticleBrush> particleBrushes;
	protected int frames;
	protected int curFrame = 0;
	protected ParticleSystem system;
	
	/**
	 * Constructs a DrawpSystem with the provided canvas and brushes
	 * @param canvas canvas object to draw on
	 * @param brushes brushes to 
	 */
	public DrawpSystem(PaintCanvas canvas, Brush[] brushes)
	{
		this.canvas = canvas;
		system = new ParticleSystem();
		particleBrushes = new ArrayList<>();
		createParticleBrushesFromBrushes(brushes);
		registerParticleBrushesInSystem();
	}
	
	private void createParticleBrushesFromBrushes(Brush[] brushes)
	{
		for(Brush b: brushes) particleBrushes.add(new ParticleBrush(b));
	}
	
	private void registerParticleBrushesInSystem()
	{
		for(ParticleBrush pb: particleBrushes) system.registerParticle(pb);
	}
	
	/**
	 * Updates the particle system by one iteration. 
	 */
	public void update()
	{
		system.update();
	}
	
	/**
	 * Applies particle brushes in system to 
	 * a canvas
	 */
	public void draw()
	{
		for(ParticleBrush pb: this.particleBrushes)
		{
			pb.apply(this.canvas);
		}
	}
	
	public ParticleSystem getParticleSystem()
	{
		return this.system;
	}
	
	/**
	 * Gets the image representing the visual state of the DrawpSystem
	 * @return
	 */
	public abstract BufferedImage getImage();
	
	@Override
	public void run()
	{
		long start = System.currentTimeMillis();
		
		for (; curFrame < frames; curFrame++)
		{
			update();
			draw();
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Completed: " + this.getClass().getSimpleName());
		System.out.println(String.format("Time: %dms", end - start));
		canvas.save(this.getClass().getSimpleName());
	}
}

