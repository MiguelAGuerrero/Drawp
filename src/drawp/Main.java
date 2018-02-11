package drawp;

public class Main
{
	//The Main class will eventually be able to read in a script
	//for a DrawpSystem, parse it, and compute the end result
	//For now, open the GUI
	public static void main(String[] args)
	{		
		int width = 500;
		int height = 500;
		new MainFrame(width, height);
	}
}
