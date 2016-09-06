import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ListClient {

	Socket serverSocket;
	String serverHostName = "localhost";
	int serverPortNumber = 4444;
	ServerListener sl;

	String username;

	ListClient() {
		Scanner inp = new Scanner(System.in);
		System.out.print("Enter username: ");
		username = inp.nextLine();

		// 1. CONNECT TO THE SERVER
		try {
			serverSocket = new Socket(serverHostName, serverPortNumber);
		} catch (Exception e) {
			System.out.println("Could not connect to server!");
			System.exit(1);
		}

		System.out.println("Connected to server");

		// 2. SPAWN A LISTENER FOR THE SERVER. THIS WILL KEEP RUNNING
		// when a message is received, an appropriate method is called
		sl = new ServerListener(this, serverSocket);
		new Thread(sl).start();

		PrintWriter out = null;

		try {
			out = new PrintWriter(new BufferedOutputStream(serverSocket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		out.println("username: " + username);
		out.flush();

		while(true){
			System.out.print("Message: ");
			String message = inp.nextLine();

			message = username + ": " + message;
			out.println(message);
			out.flush();

			System.out.println("sent!");
		}
	}

	public static void main(String[] args) {
		ListClient lc = new ListClient();
	}

}

class ServerListener implements Runnable {
	ListClient lc;
	Scanner in; // this is used to read which is a blocking call

	ServerListener(ListClient lc, Socket s) {
		try {
			this.lc = lc;
			in = new Scanner(new BufferedInputStream(s.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			String s = in.nextLine();
			System.out.print("\b\b\b\b\b\b\b\b\b");
			System.out.println(s);
			System.out.print("Message: ");
		}
	}
}
