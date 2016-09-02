//package lab3;

import java.net.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import java.io.*;

public class Server implements Runnable
{
	
	private ServerSocket serverSocket = null;
	private Thread mainThread = null;
	private File file = new File("chat.txt");
	private PrintWriter writer;
	private Thread guiMessageThread;

	public Server(int port)
	{
		//TODO Binding and starting server
		try
		{
			System.out.println("Binding to port " + port + ", please wait  ...");
			serverSocket = new ServerSocket(port);
			System.out.println("Server started: " + serverSocket);
			start();
		} catch (IOException ioe)
		{
			System.out.println("Can not bind to port " + port + ": " + ioe.getMessage());
		}
	}

	public void run()
	{
		//TODO wait for a client or show error
		
	}

	public void start()
	{

		//TODO launch a thread to read for new messages by the server
	
	}
	
	public void stop()
	{
		//TODO
		
	}

	private int findClient(int ID)
	{
		//TODO Find Client
		

		return -1;
	}

	public synchronized void handle(String input)
	{
		// TODO new message, send to clients and then write it to history
	
		//TODO update own gui
		
	}

	public synchronized void remove(int ID)
	{
		//TODO get the serverthread, remove it from the array and then terminate it
		
	}

	private void addThread(Socket socket)
	{
		System.out.println("Server got connected to a client");
		Thread t = new Thread(new ListClientHandler(clientSocket, clientNum));
		t.start();
	}

	public static void main(String args[])
	{
		Server server = null;
		server = new Server(1222);

		while (true) { // 3.
			Socket clientSocket = null;
			try {

				// 2.1 WAIT FOR CLIENT TO TRY TO CONNECT TO SERVER
				System.out.println("Waiting for client ");
				clientSocket = serverSocket.accept(); // // 4.

				// 2.2 SPAWN A THREAD TO HANDLE CLIENT REQUEST
				addThread(clientSocket);

			} catch (IOException e) {
				System.out.println("Accept failed: 4444");
				System.exit(-1);
			}

			// 2.3 GO BACK TO WAITING FOR OTHER CLIENTS
			// (While the thread that was created handles the connected client's
			// request)

		}
	}
}