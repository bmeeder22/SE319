public class main {
	Client client;

	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);

		System.out.println("Enter your name: ");
		String username = inp.nextLine();

		client = new Client('127.0.0.1',username, '1222');
	}
}