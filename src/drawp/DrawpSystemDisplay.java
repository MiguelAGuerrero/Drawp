package drawp;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import particle.ParticleSystem;

@SuppressWarnings("serial")
public class DrawpSystemDisplay extends JPanel
{
	private DrawpSystem particleSystem;
	
	public DrawpSystemDisplay(DrawpSystem ps)
	{
		this.particleSystem = ps;
		JFrame frame = new JFrame();
		frame.add(this);
		this.setPreferredSize(new Dimension(500,500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		Timer t = new Timer(1000 / 60, (ae) ->
		{
			for(int i = 0; i < 10; i++)
			{
				ps.update();
				ps.draw();
			}
			
			repaint();
			
		});
		
		t.start();
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(particleSystem.getImage(), null, 0, 0);
		g2d.drawImage(particleSystem.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
	}
}
