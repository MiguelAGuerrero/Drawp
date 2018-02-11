package drawp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainFrame extends JFrame
{
	private JPanel contentPane;
	
	public MainFrame(int width, int height)
	{
		setupSize(width, height);
		setupUI();
		finalizeAndShowWindow();
	}
	
	private void finalizeAndShowWindow()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	private void setupSize(int width, int height)
	{
		this.setPreferredSize(new Dimension(width, height));
	}
	
	private void setupContent()
	{
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		this.add(contentPane);
	}
	
	private void setupUI()
	{
		setupContent();
		JPanel buttonPanel = new JPanel();
		
		buttonPanel.add(new JButton("Start"));
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		buttonPanel.add(new JButton("Stop"));
		contentPane.add(buttonPanel, BorderLayout.SOUTH);

	}
}
