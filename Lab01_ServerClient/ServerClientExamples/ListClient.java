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

	ListClient() {
		// 1. CONNECT TO THE SERVER
		try {
			serverSocket = new Socket(serverHostName, serverPortNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}

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

		while(true){
			Scanner inp = new Scanner(System.in);

			String message = inp.nextLine();

			// 3. SEND THREE WISHES TO SERVER
			out.println(message);
			out.flush();

			System.out.println("done");
		}
		


	}

	public void handleMessage(String cmd, String s) {
		switch (cmd) {
		case "print":
			System.out.println("client side: " + s);
			break;
		case "exit":
			System.exit(-1);
			break;
		default:
			System.out.println("client side: unknown command received:" + cmd);
		}
	}

	public static void main(String[] args) {
		ListClient lc = new ListClient();
	} // end of main method

} // end of ListClient

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
		while (true) { // run forever
			System.out.println("Client - waiting to read");
			String cmd = in.next();
			String s = in.nextLine();
			lc.handleMessage(cmd, s);
		}

	}
}
