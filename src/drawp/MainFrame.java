package drawp;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame
{
	public MainFrame()
	{
		int width = 500;
		int height = 500;
		this.setPreferredSize(new Dimension(width, height));
		
		//Prepares and shows the window
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

}
