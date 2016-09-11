import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	final String serverHostName = "localhost";
	final int serverPortNumber = 4444;

	Socket serverSocket;
	ChatServerListener sl;
	Scanner inp;
	String username;
	ObjectInputStream objectIn;
	ObjectOutputStream out;

	ChatClient() {
		getUsername();
		serverConnect();
		startChatServerListener();

		try {
			out = new ObjectOutputStream(serverSocket.getOutputStream());
			out.writeObject(new Message(username, username));
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		mainloop();
	}

	private void mainloop() {
		while (true) {
			if (username.equals("admin")) { //ADMIN MENU
				System.out.println("\"BROADCAST\": Broadcast message to all clients\n\"LIST MESSAGES\": List messages so far (from chat.txt)\n" +
						"\"DELETE LINE\": Delete a selected message (from chat.txt) - give a message number");
				while (true) {
					String message = inp.nextLine();					
					
					message = username + ": " + message;
					try {
						out.writeObject(new Message(Encryption.encryptString(message), username));
						out.flush();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					break;
				}
			} else { //GENERAL USER MENU
				System.out.println("1. Send a text message to the server\n2. Send an image file to the server");
				while (true) {
					String response = inp.nextLine();
					if (response.equals("1")) { //Send a text message
						System.out.print("Message: ");
						String message = inp.nextLine();					
						
						message = username + ": " + message;
						try {
							out.writeObject(new Message(Encryption.encryptString(message), username));
							out.flush();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						break;
					} else if (response.equals("2")) { //Send an image file
						System.out.print("File pathname: ");
						String pathname = inp.nextLine();
						
						File file = new File(pathname);
						String encryptedFileData = "";
						try {
							encryptedFileData = Encryption.encryptFileToString(file);
							Message encryptedFile = new Message(encryptedFileData, username, pathname);
							out.writeObject(encryptedFile);
							out.flush();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						break;
					}
				}
	
				System.out.println("sent!");
			}
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
	ObjectInputStream in; // this is used to read which is a blocking call
	Socket socket;
//	Scanner inp;

	ChatServerListener(ChatClient lc, Socket s) {
		this.client = lc;
		this.socket = s;
//		inp = userInput;
	}

	@Override
	public void run() {
		try {
			in = new ObjectInputStream(socket.getInputStream());
			while (true) {
				Message m;
				m = (Message) in.readObject();
				if (!m.isFile()) {
					String s = Encryption.decryptStringFromString(m.getData());
					System.out.print("\b\b\b\b\b\b\b\b\b");
					System.out.println(s);				
				} else {
					System.out.println("File recieved from " + m.getUsername() + ": " + m.getPathname() + ".");
//					System.out.println("Enter the path you would like to save this file to: ");
//					String newpath = "";
//					String newPathname = client.inp.nextLine();
					Encryption.decryptFileFromString(m.getData(), m.getPathname());
					System.out.println("File saved!");
				}
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}
