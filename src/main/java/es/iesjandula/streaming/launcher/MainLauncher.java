package es.iesjandula.streaming.launcher;

/**
 * 
 * @author Pablo
 * @author Javier
 * @author Alejandro
 * 
 * @see -The class with main method
 */
public class MainLauncher 
{
	/**
	 * The main method
	 * @param args the main arguments
	 */
	public static void main(String[] args) 
	{
		Launcher launch = new Launcher();
		launch.startStreaming(launch);
	}

}
