import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.swing.JOptionPane;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.BufferedWriter;
import java.io.FileWriter;




public class Spam
{

	private Properties properties;
	private String username;
	private String password;
	private String fromEmailAddress;
	private String toEmailAddress;
	private String subject;
	private String textMessage;
	private Message message;
	private int messageCount;
	private String victimName;
	
	private static Spam spam = new Spam();
	
	private Spam()
	{	
		this.properties = new Properties();
		this.properties.put("mail.smtp.auth", "true");
		this.properties.put("mail.smtp.starttls.enable", "true");
		this.properties.put("mail.smtp.host", "smtp.gmail.com");
		this.properties.put("mail.smtp.port", "587");

		this.username = username;
		this.password = password;
		this.fromEmailAddress = fromEmailAddress;
		this.victimName = victimName;
		this.toEmailAddress = toEmailAddress;
		this.subject = subject;	
		this.textMessage = textMessage;

		this.message = message;
		this.messageCount = messageCount;

		

	}
	public static Spam getInstance()
	{
		return spam;

	}
	
	public static void setInstance(Spam oldSpam)
	{
		spam = oldSpam;

	}

		
			
		//email of sender		
	public void setUserName( String userName)	
	{
		this.username = userName;

	}

	public void setPassword(String pass)
	{
		this.password = pass;

	}

	public void setSenderEmailAddress(String senderEmail)
	{
		this.fromEmailAddress = senderEmail;

	}

	public void setTargetName(String victName)
	{	this.victimName = victName; }

	public void setTarget(String target)
	{
		this.toEmailAddress = target;
	}

	public void setSubject(String sub)
	{
		this.subject = sub;

	}

	public void setMessage(String messg)
	{

		this.textMessage = messg;
	}

	public void setMessageCount(int messages)
	{
		this.messageCount = messages;
	}

	public boolean initializeMessage()
	{
		Session session = Session.getInstance(properties, new GMailAuthenticator(username, password));		
		boolean didInit = true;


		try
		{
			this.message = new MimeMessage(session);
			this.message.setFrom(new InternetAddress(fromEmailAddress));
			this.message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmailAddress));
			this.message.setSubject(subject);
			this.message.setText(textMessage);
		


		}
		catch(MessagingException e)
		{
			didInit = false;
			throw new RuntimeException(e);
		}
		catch(NullPointerException n)
		{
			didInit = false;
			JOptionPane.showMessageDialog( null, "Missing information required to initialize fully\n" , "Warning" , JOptionPane.PLAIN_MESSAGE);


		}
		
	
		return didInit;



	}

	public void sendMessage()
	{
		try
		{

			while(this.messageCount != 0)
			{

				Transport.send(this.message);	
				messageCount--;
			}


		}
		catch(MessagingException e)
		{
			JOptionPane.showMessageDialog( null, "Invalid information entered for email account. ex. password or username" , "Warning" , JOptionPane.PLAIN_MESSAGE);



			throw new RuntimeException(e);
		}

	}

	public void saveInstance()
	{
	
	
		try
		{

			ObjectOutputStream output = new ObjectOutputStream( new FileOutputStream( "data.ser"));	//creates an OjbectOutputStream
			output.writeObject(getInstance());	//serializes the instance of Spam
			output.close();	//closes the output stream
		}
		catch(IOException e)	
		{
			System.err.println( "Error");
		}


	}
		


	public String getAttackLog()
	{
		String log = "";

		try
		{
			File reader = new File("AttackLog.txt");
			Scanner lineReader = new Scanner(reader);
			lineReader.useDelimiter(",");
			
			while(lineReader.hasNextLine()  == true)	//loops while there are lines of input to still read
			{	
				
					
				String entireLine = lineReader.nextLine();
				String[] tokenArray = entireLine.split(",");	//breaks the file into tokens delimited by ","
				
				String userName = (tokenArray[0]);	//turns id String into a int id
				log = log + userName + ",";
				String name = (tokenArray[1]);	//retrieves the name
				log = log + name + ",";
				String numberAttacked = (tokenArray[2]);	//retrieves the species
				log = log + numberAttacked +",";
				String messagesSent = (tokenArray[3]);
				log = log + messagesSent + "\n";
				
				
			
			}
			
			lineReader.close();
		}
		catch(FileNotFoundException e)
		{	System.out.println( "File not found"); }


		return log;
	}		

	public static void writeToFile(String userName , String name , String numberAttacked , String messagesSent)
	{

		BufferedWriter writer = null;
		try
		{
			 writer = new BufferedWriter(new FileWriter("AttackLog.txt", true));
		 	 writer.write( "Email Username: " +userName+" , " + " Victim Name: "+name+" , " + " Number attacked: " + numberAttacked+" , " + " Messages Sent: " + messagesSent);	
			 writer.newLine();
			 writer.flush(); 
		         writer.close();	//closes the writer

		
		}
		catch( FileNotFoundException e)
		{	
			System.out.println( " File Error");
		}
		catch( UnsupportedEncodingException u)
		{
			System.out.println( " Unsupported encoding error" );
		}
		catch(IOException i)
		{	System.out.println( "io exception"); }
			
	}

	public void clearLog()
	{	File file = new File("AttackLog.txt");
		file.delete();

	}
	



}	//end class






