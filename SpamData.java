import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SpamData implements java.io.Serializable
{

	private String username;
	private String password;
	private String fromEmailAddress;
	private String victimName;
	private String toEmailAddress;
	private String subject;
	private String textMessage;
	private int messageCount;
	private static SpamData data = new SpamData();

	private SpamData()
	{
	
		this.username = username;
		this.password = password;
		this.fromEmailAddress = fromEmailAddress;
		this.victimName = victimName;
		this.toEmailAddress = toEmailAddress;
		this.subject = subject;	
		this.textMessage = textMessage;
		this.messageCount = messageCount;
	}

	public static SpamData getInstance()
	{	return data; } 	

	public static void setInstance(SpamData oldData)
	{	data = oldData;	}
	
	//email of sender		
	public void setUserName( String userName)	
	{ this.username = userName; }

	public void setPassword(String pass)
	{ this.password = pass; }

	public void setSenderEmailAddress(String senderEmail)
	{ this.fromEmailAddress = senderEmail; }
	
	public void setTargetName(String targetName)
	{	this.victimName = targetName; }

	public void setTarget(String target)
	{ this.toEmailAddress = target; }

	public void setSubject(String sub)
	{ this.subject = sub; }

	public void setMessage(String messg)
	{ this.textMessage = messg; }
 
	public void setMessageCount(int messages)
	{ this.messageCount = messages; }

	public String getUserName()	
	{ return this.username; }

	public String getPassword()
	{ return this.password; }

	public String getSenderEmailAddress()
	{ return this.fromEmailAddress; }

	public String getTargetName()
	{ return this.victimName;  }

	public String getTarget()
	{ return this.toEmailAddress; }

	public String getSubject()
	{ return this.subject; }

	public String getMessage()
	{ return this.textMessage; }

	public int getMessageCount()
	{ return this.messageCount; }

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
				



}	//end class
