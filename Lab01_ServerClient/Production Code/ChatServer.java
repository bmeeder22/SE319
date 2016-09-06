// GOALS
//
// 1. to show sample Server code
// Note that the server is running on LOCALHOST (which is THIS computer) and the 
// port number associated with this server program is 4444.
// The accept() method just WAITS until some client program tries to access this server
//
// 2. to show how a thread is created to handle client request
//

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

public class ChatServer {

	ArrayList<ChatClientHandler> clients = new ArrayList<>();
	ServerSocket serverSocket = null;
	int clientNum = 0;

	ChatServer() {
		createServerSocket();
		mainloop();
	}

	private void createServerSocket() {
		try {
			serverSocket = new ServerSocket(4444);
			System.out.println(serverSocket);
		} catch (IOException e) {
			System.out.println("Could not listen on port: 4444");
			System.exit(-1);
		}
	}

	private void mainloop() {
		while (true) {
			Socket clientSocket;
			try {

				System.out.println("Waiting for client " + (clientNum + 1)
						+ " to connect!");
				clientSocket = serverSocket.accept();

				System.out.println("Server got connected to a client"
						+ ++clientNum);
				ChatClientHandler newClient = new ChatClientHandler(clientSocket, clientNum, this);
				clients.add(newClient);

				Thread t = new Thread(newClient);
				t.start();

			} catch (IOException e) {
				System.out.println("Accept failed: 4444");
				System.exit(-1);
			}
		}
	}

	public synchronized void sendChatToOtherClients(String message, int id) {
		for(ChatClientHandler client: clients) {
			if(client.num != id)
				client.sendChatToClient(message);
		}
	}

	public static void main(String[] args) throws IOException {
		ChatServer server = new ChatServer();
	}
}

class ChatClientHandler implements Runnable {
	Socket s; // this is socket on the server side that connects to the CLIENT
	int num; // keeps track of its number just for identifying purposes
	String username;
	PrintWriter out;
	ChatServer listServer;

	ChatClientHandler(Socket s, int n, ChatServer listServer) {
		this.s = s;
		num = n;
		this.listServer = listServer;
	}

	// This is the client handling code
	// This keeps running handling client requests 
	// after initially sending some stuff to the client
	public void run() { 
		Scanner in;
		
		try {

			in = new Scanner(new BufferedInputStream(s.getInputStream())); 
			out = new PrintWriter(new BufferedOutputStream(s.getOutputStream()));

			username = in.nextLine();
			if(username != null) {
				System.out.println("Client " + num + " connected to server with username " + username);
			}

			System.out.println();
			
			while (true) {
				String s = in.nextLine();
				handleRequest(s);
			}
		} catch (IOException e) {
			System.out.println("Client " + num + " with username " + username + " has left the chat");
		}
	}

	void handleRequest(String message) {
		write(message);
		System.out.println(message);
		listServer.sendChatToOtherClients(message, num);
	}

	void sendChatToClient(String message) {
		out.println(message);
		out.flush();
	}

	String decrypt() {return null;}

	String encrypt() {return null;}

	public void write(String s) {
		try {
			Writer file = new BufferedWriter(new FileWriter("chat.txt", true));
			file.append(s);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
