package drawp;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import particle.ParticleSystem;

/**
 * DrawSystemDispaly is responsible for visualizing DrawpSystems in real-time. 
 * 
 * a Drawp System.
 * @author Miguel Guerrero
 */

@SuppressWarnings("serial")
public class DrawpSystemDisplay extends JPanel
{
	private static int DEFAULT_FRAMERATE = 60;
	private static int DEFAULT_UPDATERATE = 1;
	private DrawpSystem particleSystem;
	
	/**
	 * Creates a display for a DrawpSystem
	 * @param particleSystem a DrawpSystem to be displayed
	 */
	public DrawpSystemDisplay(DrawpSystem particleSystem)
	{
		
		this(particleSystem, DEFAULT_FRAMERATE, DEFAULT_UPDATERATE);
	}
	
	/**
	 * Creates a display for a DrawpSystem
	 * @param particleSystem a DrawpSystem to be displayed
	 */
	public DrawpSystemDisplay(DrawpSystem particleSystem, int frameRate, int updateRate)
	{
		this.particleSystem = particleSystem;
		JFrame frame = new JFrame();
		frame.add(this);
		
		int width = 500;
		int height = 500;
		this.setPreferredSize(new Dimension(width, height));
		
		//Prepares and shows the window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		//Rate of update/draw cycles
		int FPS = 1000 / frameRate;
		
		//Naive approach to updating the display using a 
		//timer to call repaint() every frameRate of milliseconds
		Timer timer = new Timer(FPS, (ae) ->
		{
			
			//Because DrawpSystems "move" by calling update() explicitly, 
			//the rate at which particles appear to move is  dependent on 
			//updateRate
			//The call to draw() allows the brushes to touch the canvas,
			//so one can see every call to update
			for(int i = 0; i < updateRate; i++)
			{
				particleSystem.update();
				particleSystem.draw();
			}
			
			repaint();
		});
		
		
		timer.start();
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(particleSystem.getImage(), null, 0, 0);
		g2d.drawImage(particleSystem.getImage(), 0, 0, 
				this.getWidth(), this.getHeight(), null);
	}
}
