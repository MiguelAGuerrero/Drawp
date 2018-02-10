package drawp;

import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrame extends JFrame
{
	public MainFrame()
	{
		setupSize();
		finalizeAndShowWindow();
	}
	
	private void finalizeAndShowWindow()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	private void setupSize()
	{
		int width = 500;
		int height = 500;
		this.setPreferredSize(new Dimension(width, height));
	}
}
