//==========
//Author: Joshua Eaton
//The purpose of class RiskGuiRunner is to start the run of the GUI
//Services provided by this class
//
//
//
//==========
import javax.swing.JFrame;

public class SpammerGuiRunner
{

	public SpammerGuiRunner()
	{
		
		SpammerGui spammerGui = SpammerGui.getInstance();	//creats an object riskGui which is the main menu
		spammerGui.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);	//sets the default close operation
		spammerGui.setExtendedState(JFrame.MAXIMIZED_BOTH);	//sets JFrame to full screen
		spammerGui.setVisible(true);	//makes it visible

	}


}
