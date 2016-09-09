
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	final String serverHostName = "localhost";
	final int serverPortNumber = 4444;

	Socket serverSocket;
	ChatServerListener sl;
	Scanner inp;
	String username;
	PrintWriter out;

	ChatClient() {
		getUsername();
		serverConnect();
		startChatServerListener();

		try {
			out = new PrintWriter(new BufferedOutputStream(serverSocket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		out.println(username);
		out.flush();

		mainloop();
	}

	private void mainloop() {
		while(true){
			System.out.print("Message: ");
			String message = inp.nextLine();

			message = username + ": " + message;
			out.println(Encryption.encryptString(message));
			out.flush();

			System.out.println("sent!");
		}
	}

	private void serverConnect() {
		try {
			serverSocket = new Socket(serverHostName, serverPortNumber);
		} catch (Exception e) {
			System.out.println("Could not connect to server!");
			System.exit(1);
		}

		System.out.println("Connected to server");
	}

	private void getUsername() {
		inp = new Scanner(System.in);
		System.out.print("Enter username: ");
		username = inp.nextLine();
	}

	private void startChatServerListener() {
		sl = new ChatServerListener(this, serverSocket);
		new Thread(sl).start();
	}

	public static void main(String[] args) {
		ChatClient client = new ChatClient();
	}

}

class ChatServerListener implements Runnable {
	ChatClient client;
	Scanner in; // this is used to read which is a blocking call

	ChatServerListener(ChatClient lc, Socket s) {
		try {
			this.client = lc;
			in = new Scanner(new BufferedInputStream(s.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			String s = Encryption.decryptStringFromString(in.nextLine());
			System.out.print("\b\b\b\b\b\b\b\b\b");
			System.out.println(s);
			System.out.print("Message: ");
		}
	}
}
