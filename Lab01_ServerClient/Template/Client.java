

import java.net.*;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.io.*;

public class Client implements Runnable
{
	private Socket socket = null;
	private Thread thread = null;
	private DataOutputStream streamOut = null;
	//private ClientThread client = null;
	private String username;
	private ChatGUI frame;

	public Client(String ipAddr, String username, int serverPort)
	{
		this.username = username;
		
		// set up the socket to connect to the gui
		try
		{
			socket = new Socket(ipAddr, serverPort);
			start();
		} catch (UnknownHostException h)
		{
			System.out.println(h.getMessage());
			System.exit(1);
		} catch (IOException e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}

	public void run()
	{
		//TODO check for a new message, once we receive it, steamOut will send it to the server
		
	}

	public synchronized void handleChat(String msg)
	{
		//TODO
	}

	public void start() throws IOException
	{
		

	}

	public void stop()
	{
		//TODO
	
	}

	
}
