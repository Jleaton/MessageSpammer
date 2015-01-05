//==========
//Author: Joshua Eaton
//The purpose of class GameLoader is to display the game loading screen
//Services provided by this class
//
//
//
//==========

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class GameLoader extends JFrame
{

	private JTextArea output;	//for output
	private JScrollPane scroll;	//scrolling for output
	private File file;

	public GameLoader()
	{
		super( "File Browser");	//title for the window
		
		output = new JTextArea();	//used for text output
		scroll = new JScrollPane( output);	//adds scroll bar fnctionality
		add( scroll, BorderLayout.CENTER);
		setSize(500, 500);	//set GUI size
		setVisible(true);	//display GUI

		analyzePath();	//create and analyze a file
	
	


	}	//end GameLoader Constructor


	public File getFile()
	{
		return file;


	}



	private File getSavedGame()	//returns the saved game that the user selects
	{
		JFileChooser fileChooser = new JFileChooser();	//creates a JFileChooser component	
		fileChooser.setFileSelectionMode( JFileChooser.FILES_AND_DIRECTORIES);	//sets the type of selection allowed

		int result = fileChooser.showOpenDialog( this );	//stores int to allow the screen to become not visible when not in use
	
		if( result == JFileChooser.CANCEL_OPTION );
		{	
			setVisible(false);	//hides the screen until further use
		}

		File fileName = fileChooser.getSelectedFile();	//gets the selected file

		if( (fileName == null) || ( fileName.getName().equals( " ") ) )	//displays an error message if an invalid name is choosen
		{

			JOptionPane.showMessageDialog( this, " Invalid Name" , "Invalid Name", JOptionPane.ERROR_MESSAGE);
				
		}
		System.out.print( fileName + " will be loaded");	//so we know that the correct file is loaded
		file = fileName;	//returns the file selected
		
		return file;


	}	//end method getSavedGame

	public void analyzePath()	//allows the user to choose the specific file or directory name
	{
		


		File name = getSavedGame();	//creates a File object depending on user input
		
		if(name == null)
		{	
			return;
		}

		if( name.exists() )	//outputs information about the name if it exist
		{
			output.setText( String.format( "%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s",
			name.getName() , "exist" ,
		       	(name.isFile() ? "is a file" : "is not a file"), 
			(name.isDirectory() ? "is a directory" : 
			 "is not a directory" ),
			(name.isAbsolute() ? "is absolute path" :
			"is not absolute path") , "Last modified: ",
	       		name.lastModified(), "Length: ", name.length(),
			"Path: ", name.getPath(), "Absolute path: ",
       			name.getAbsolutePath(), "Parent: ", name.getParent() ) );


		}

		if( name.isDirectory())	//output directory listing
		{
			
			
				String[] directory = name.list();
				output.append( "\n\nDirectory contents:\n");

				for( String directoryName : directory)
				{
					output.append( directoryName + "\n" );

				}
			
		}
	
		
	}	//end class analyzePath


}	//end class GameLoader
