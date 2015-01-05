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

public class InitGui extends JPanel
{
	JButton back;
	JButton userName;
	JButton password;
	JButton senderEmail;
	JButton victimName;
	JButton targetEmail;
	JButton subject;
	JButton message;
	JButton messageCount;
	JButton initMessage;
	JButton sendMessage;
	JButton clear;
	private boolean didInit;
	private InitGui initComponent;
	
        SpamData data = SpamData.getInstance();	
	SpammerGui gui = SpammerGui.getInstance();
	Spam spammer = spammer = Spam.getInstance();


	
	public InitGui()
	{
			
		setLayout( new FlowLayout() );
		didInit = false;
		initComponent = this;



		Dimension a = new Dimension( 300 , 200);
		back = new JButton( "BACK");
		back.setPreferredSize(a);
		add(back);
		
		clear = new JButton( "Clear Attack Log");
		clear.setPreferredSize(a);
		add(clear);

	
		userName = new JButton( "User Name");
		userName.setPreferredSize(a);
		add(userName);

		password = new JButton( "Password");
		password.setPreferredSize(a);
		add(password);

		senderEmail = new JButton( "Sender Email");
		senderEmail.setPreferredSize(a);
		add(senderEmail);
	
		victimName = new JButton( "Victim Name");
		victimName.setPreferredSize(a);
		add(victimName);
		
		targetEmail = new JButton( "Target Number");
		targetEmail.setPreferredSize(a);
		add(targetEmail);

		subject = new JButton( "Subject");
		subject.setPreferredSize(a);
		add(subject);

		message = new JButton( "Message");
		message.setPreferredSize(a);
		add(message);

		messageCount = new JButton( "MESSAGE COUNT");	//creates a playerCount JButton
		messageCount.setPreferredSize(a);	//sets the preferred dimensions of the JButton
		add( messageCount);	//adds playerCount to the JPanel

		initMessage = new JButton( "Initialize Message");
		initMessage.setPreferredSize(a);
		add(initMessage);

		sendMessage = new JButton( "Start Message Spam");
		sendMessage.setPreferredSize(a);
		add(sendMessage);



		

		ButtonHandler handler = new ButtonHandler();
	
		back.addActionListener(handler);
		userName.addActionListener(handler);
		password.addActionListener(handler);
		senderEmail.addActionListener(handler);
		victimName.addActionListener(handler);
		targetEmail.addActionListener(handler);
		subject.addActionListener(handler);
		message.addActionListener(handler);
		messageCount.addActionListener(handler);
		initMessage.addActionListener(handler);
		sendMessage.addActionListener(handler);
		clear.addActionListener(handler);
	}
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if( event.getSource() == back)
			{	gui.remove(initComponent);
				gui.buttonsPanel.setVisible(true);
			

			}
			if( event.getSource() == clear)
			{	
				spammer.clearLog();
			}

		
			if( event.getSource() == userName)
			{
			
				String userName = JOptionPane.showInputDialog( "Enter email username");	//dialog box that prompts to enter the username
				data.setUserName(userName);
				spammer.setUserName(data.getUserName());	//mvc sets the username
				JOptionPane.showMessageDialog( null, "You set the username to " + userName +"\n", "Username" , JOptionPane.PLAIN_MESSAGE);
			

			}

			
			if( event.getSource() == password)
			{
			
				String password = JOptionPane.showInputDialog( "Enter email password");	//dialog box that prompts to enter the password
				data.setPassword(password);
				spammer.setPassword(data.getPassword());	//mvc sets the password
				JOptionPane.showMessageDialog( null, "Password entered as " + password + "\n" , "Password" , JOptionPane.PLAIN_MESSAGE);
			

			}
			

			if( event.getSource() == senderEmail)
			{
			
				String senderEmail = JOptionPane.showInputDialog( "Enter your email");	//dialog box that prompts to enter the users email
				data.setSenderEmailAddress(senderEmail);
				spammer.setSenderEmailAddress(data.getSenderEmailAddress());	//mvc sets the sender email
				JOptionPane.showMessageDialog( null, "You set the email to " + senderEmail , "Sender Email" , JOptionPane.PLAIN_MESSAGE);
			

			}
		
			if( event.getSource() == victimName)
			{
			
				String victimName = JOptionPane.showInputDialog( "Enter target's name");	//dialog box that prompts to enter the target number
				data.setTargetName(victimName);
				spammer.setTargetName(data.getTargetName());	//mvc sets the target number
				JOptionPane.showMessageDialog( null, "You set the target to " + victimName +"\n" , "Target" , JOptionPane.PLAIN_MESSAGE);
			

			}



		
			if( event.getSource() == targetEmail)
			{
			
				String targetEmail = JOptionPane.showInputDialog( "Enter target's number");	//dialog box that prompts to enter the target number
				data.setTarget(targetEmail);
				spammer.setTarget(data.getTarget());	//mvc sets the target number
				JOptionPane.showMessageDialog( null, "You set the target to " + targetEmail +"\n" , "Target's number" , JOptionPane.PLAIN_MESSAGE);
			

			}

		
			if( event.getSource() == subject)
			{
			
				String subject = JOptionPane.showInputDialog( "Enter subject");	//dialog box that prompts to enter the subject name
				data.setSubject(subject);
				spammer.setSubject(data.getSubject());	//mvc sets the subject
				JOptionPane.showMessageDialog( null, "You set the subject to " + subject + "\n" , "Subject" , JOptionPane.PLAIN_MESSAGE);
			

			}
		
		
			if( event.getSource() == message)
			{
			
				String message = JOptionPane.showInputDialog( "Enter message");	//dialog box that prompts to enter the username
				data.setMessage(message);
				spammer.setMessage(data.getMessage());	//mvc sets the username
				JOptionPane.showMessageDialog( null, "You set the message to be " + message + "\n" , "Message" , JOptionPane.PLAIN_MESSAGE);
			

			}


			if( event.getSource() == messageCount)
			{
				//this event will prompt the user to enter in the number of players and store that number
			
			
				String playerNumber = JOptionPane.showInputDialog( "Enter number of messages to sent");	//dialog box that prompts to enter number of msg
				int messages = Integer.parseInt( playerNumber);	//parses the string value into an int value
				data.setMessageCount(messages);
				System.out.println( "data messages updated to " + data.getMessageCount() );
				spammer.setMessageCount(data.getMessageCount());	//mvc sets the amount of messages to send
				JOptionPane.showMessageDialog( null, "You have chosen to send " + messages + " messages " , "Number of Messages" , JOptionPane.PLAIN_MESSAGE);
				//shows the number of messages choosen
			}
	
		



			if( event.getSource() == initMessage)
			{

				if(gui.didLoad() == true)
				{	System.out.println("Settting " + data.getUserName() );
					System.out.println("Updating message count to " + data.getMessageCount() );
					spammer.setUserName(data.getUserName());	//mvc sets the username

					spammer.setPassword(data.getPassword());	
					spammer.setSenderEmailAddress(data.getSenderEmailAddress());	//mvc sets the sender email

					spammer.setTarget(data.getTarget());	//mvc sets the target number

					spammer.setSubject(data.getSubject());	//mvc sets the subject

					spammer.setMessage(data.getMessage());	//mvc sets the username

					spammer.setMessageCount(data.getMessageCount());	

				}


				didInit = spammer.initializeMessage();
										

			}
			
			if( event.getSource() == sendMessage)
			{


				spammer.writeToFile(data.getUserName() , data.getTargetName(), data.getTarget() , Integer.toString(data.getMessageCount()));



				if(didInit == true)
				{
					spammer.sendMessage();
				}
				else
				{
					JOptionPane.showMessageDialog( null, "Must initialize message before starting\n" , "Warning" , JOptionPane.PLAIN_MESSAGE);


				}
			}



		}



	}

}

