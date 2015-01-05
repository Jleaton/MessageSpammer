import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JFrame;


public class AttackLogGui extends JFrame 
{
	JPanel buttonsPanel;
	JButton back;
	public AttackLogGui()
	{
		
	//	setLayout( new FlowLayout() );
		/**
	 	buttonsPanel = new JPanel();
		buttonsPanel.setLayout( new BorderLayout() );
		buttonsPanel.setVisible(true);
		add( buttonsPanel , BorderLayout.CENTER);	
		**/	



		JFrame.setDefaultLookAndFeelDecorated(true);
   	 JFrame frame = new JFrame("JTextArea Test");
   	 frame.setLayout(new FlowLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String text = "A JTextArea object represents a multiline area for displaying textnd produce say the ten moments parties";

JTextArea textAreal = new JTextArea(text, 5, 10);
    textAreal.setPreferredSize(new Dimension(100, 100));
    JTextArea textArea2 = new JTextArea(text, 5, 10);
    textArea2.setPreferredSize(new Dimension(100, 100));


    		JScrollPane scrollPane = new JScrollPane(textArea2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
    	    	JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
   		 textAreal.setLineWrap(true);
    		textArea2.setLineWrap(true);
    		  frame.add(textAreal);
  		  frame.add(scrollPane);
		  frame.pack();
        	  frame.setVisible(true);



//		
	Dimension a = new Dimension( 300 , 250);
		back = new JButton( "BACK");
		back.setPreferredSize(a);
		frame.add(back, BorderLayout.EAST);
		back.setVisible(true);
	







	}



}
