
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
        try {
            Writer file = new BufferedWriter(new FileWriter("chat.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    boolean isAdmin;

	ChatClientHandler(Socket s, int n, ChatServer listServer) {
		this.s = s;
		num = n;
		this.listServer = listServer;
        isAdmin = false;
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
			System.out.println("Client " + num + " connected to server with username " + username);
			if(username.equals("ADMIN")) {
				isAdmin = true;
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
		message = Encryption.decryptStringFromString(message);
        if(isAdmin && handleAdminMessages(message)) {
            return;
        }

		write(message);
		System.out.println(message);
		listServer.sendChatToOtherClients(message, num);
	}

    boolean handleAdminMessages(String message) {
        if(message.contains("BROADCAST")) {
            listServer.sendChatToOtherClients("BROADCAST FROM " + message.replace("BROADCAST ", ""), num);
            return true;
        }
        else if(message.equals("ADMIN: LIST MESSAGES")) {
            BufferedReader br;
            try {
                br = new BufferedReader(new FileReader("chat.txt"));
                String line;
                while ((line = br.readLine()) != null) {
                    out.println(line);
                }
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        else if(message.contains("DELETE LINE")) {
            int lineNum = Character.getNumericValue(message.charAt(19));
            deleteLine(lineNum);
            return true;
        }

        return false;
    }

    void deleteLine(int lineNum) {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("chat.txt"));
            String output = "";
            String line;
            for(int i=1; i<lineNum; i++) {
                if((line = br.readLine()) != null) {
                    output += line + '\n';
                }
            }
            br.readLine();
            while ((line = br.readLine()) != null) {
                output += line + '\n';
            }

            System.out.println("START OUTPUT: " + output);
            Writer newFile = new BufferedWriter(new FileWriter("chat.txt"));
            newFile.write(output);
            newFile.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	void sendChatToClient(String message) {
		out.println(Encryption.encryptString(message));
		out.flush();
	}

	public void write(String s) {
		try {
            Writer file = new BufferedWriter(new FileWriter("chat.txt", true));
			file.append(s + '\n');
            file.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
