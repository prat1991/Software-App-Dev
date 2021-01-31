
//Imported classes used in order to run the GUI application
import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class DriveGui
{
	public static void main(String args[])
	{ // PROGRAM START because its the start of main method body

		try
		{
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
			{
				if ("Nimbus".equals(info.getName())) // searching for Nimbus look and feel for GUI
				{
					UIManager.setLookAndFeel(info.getClassName()); // Setting Nimbus look and feel for GUI
					break;
				}
			}
		}
		catch (Exception errorMessage)
		{
			errorMessage.getStackTrace(); // tells user which line generated the exception
			System.out.println("Nimbus is not avaliable; select another GUI look"); // tells user what the exception
																					// means
		}

		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				new DesignGui().setVisible(true); // allows us the see the GUI
			}
		});
	} // PROGRAM END because its the end of the main method body
}
