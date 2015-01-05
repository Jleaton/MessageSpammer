import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Container;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SpammerGui extends JFrame
{
	private InitGui initializationGui;
	public JPanel buttonsPanel;
	private JButton initialize;
	private JButton save;
	private JButton load;
	private JButton quit;
	private JButton log;
	private Spam spammer = Spam.getInstance();
	private SpamData data = SpamData.getInstance();
	private boolean didLoad;

	private static SpammerGui gui = new SpammerGui();
	
	private SpammerGui()
	{
	
		super("SPAMMER");


		this.setLayout( new BorderLayout() );

		buttonsPanel = new JPanel();
		buttonsPanel.setLayout( new BorderLayout() );
		buttonsPanel.setVisible(true);
		add( buttonsPanel , BorderLayout.CENTER);	

	
	//	Icon endGame = new ImageIcon( getClass().getResource( "end.png"));
		Dimension a = new Dimension( 200 , 250);
		initialize = new JButton("Initialize");
		initialize.setPreferredSize(a);
		buttonsPanel.add(initialize , BorderLayout.NORTH);

		//future button to record past attacks
		
	//	Icon endGame = new ImageIcon( getClass().getResource( "end.png"));
		Dimension b = new Dimension( 200 , 200);
		save = new JButton("Save");
		save.setPreferredSize(b);
		buttonsPanel.add(save , BorderLayout.WEST);

	
		Dimension d = new Dimension( 200 , 200);
		load = new JButton("Load");
		load.setPreferredSize(d);
		buttonsPanel.add(load , BorderLayout.EAST);
		


		Dimension e = new Dimension( 200 , 250);
		log = new JButton("Attack Log");
		log.setPreferredSize(e);
		buttonsPanel.add(log , BorderLayout.CENTER);
		

		Icon endGame = new ImageIcon( getClass().getResource( "end.png"));
		Dimension c = new Dimension( 200 , 250);
		quit = new JButton( endGame );
		quit.setPreferredSize(c);
		buttonsPanel.add(quit , BorderLayout.SOUTH);
		

		ButtonHandler handler = new ButtonHandler();
		initialize.addActionListener(handler);
		save.addActionListener(handler);
		log.addActionListener(handler);
		load.addActionListener(handler);
		quit.addActionListener(handler);
	
	}

	public static SpammerGui getInstance()
	{
		return gui;

	}
	
	public boolean didLoad()
	{	return didLoad; }

	private class ButtonHandler implements ActionListener
	{

		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource() == initialize)
			{
				initializationGui = new InitGui();
				add(initializationGui);
				initializationGui.setVisible(true);
				buttonsPanel.setVisible(false);
			}

			if(event.getSource() == save)
			{
				data.saveInstance();
		
			}
			if(event.getSource() == log)
			{
				JFrame.setDefaultLookAndFeelDecorated(true);
			   	JFrame frame = new JFrame("Attack Log");
			   	frame.setLayout(new FlowLayout());
  
				String text = spammer.getAttackLog();				



				JTextArea textArea = new JTextArea(text, 15 , 105);
				textArea.setPreferredSize(new Dimension(300, 300));


    				JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
    	    			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
   			      	textArea.setLineWrap(true);
  				frame.add(scrollPane);
		         	frame.pack();
        			frame.setVisible(true);
				textArea.setCaretPosition(textArea.getDocument().getLength());




			}

			if(event.getSource() == load)
			{
				
				
	
				GameLoader loader = new GameLoader();
				File file = loader.getFile();
				
				if(file != null)
				{
					String fileName = file.getName();
					SpamData desData = null;
			
					try
					{
						FileInputStream fileIn = new FileInputStream(fileName);
						ObjectInputStream in = new ObjectInputStream(fileIn);
						desData =  (SpamData) in.readObject();
						in.close();
						fileIn.close();
						didLoad = true;


					}
					catch(IOException e)
					{
						e.printStackTrace();
						return;

					}
					catch(ClassNotFoundException c)
					{
						System.out.println("Class not found");
						c.printStackTrace();
						return;
					}


					data.setInstance(desData);
					System.out.println( "LOADED ");	
					didLoad = true;	

					JOptionPane.showMessageDialog( null, "File " + fileName + " Loaded " , "File Loaded", JOptionPane.PLAIN_MESSAGE);

				}	//end if
				else
				{
					JOptionPane.showMessageDialog( null, "File not Loaded" , "Loading Error", JOptionPane.ERROR_MESSAGE);

				}	
				

			
			}
		
			if(event.getSource() == quit)
			{
				System.exit(0);

			}


		}


	}

}
