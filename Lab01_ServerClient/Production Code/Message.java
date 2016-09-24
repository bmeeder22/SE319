import java.io.Serializable;

public class Message implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String data;
	private String username;
	private boolean isFile;
	private String pathname;
	
	Message(String data, String username) {
		this.data = data;
		this.username = username;
		this.isFile = false;
	}
	
	Message(String data, String username, String pathname) {
		this.data = data;
		this.username = username;
		this.pathname = pathname;
		this.isFile = true;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getData() {
		return data;
	}
	
	public String getPathname() {
		return pathname;
	}
	
	public boolean isFile() {
		return this.isFile;
	}
}
