package examples;

import drawp.DrawpSystem;
import drawp.ParticleBrush;
import paint.Brush;
import paint.PaintCanvas;
import particle.VectorField;

public class VectorFieldDemo extends DrawpSystem {

	public VectorFieldDemo(PaintCanvas canvas, Brush[] brushes)
	{
		super(canvas, brushes);
		
		VectorField vf = new VectorField((x, y) -> {
			return new double[] {-y / 250, x / 500};
			}, 
				this.canvas.WIDTH / 2, this.canvas.HEIGHT / 2); 
		
		double interval = 360 / this.particleBrushes.size();
		int i = 0;
		for(ParticleBrush pb: this.particleBrushes)
		{
			pb.setLocation(500, 500);
			pb.setVelocity(50, 0);
			pb.setAngle(interval * i);
			i+= 1;
		}
		
		this.system.registerForce(vf);
	}
}
