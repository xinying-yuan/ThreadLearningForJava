package Thread_Specific_Storage;

public class Main {

	public static void main(String[] args) {
		new ClientThread("alice").start();
		new ClientThread("bob").start();
		new ClientThread("chris").start();
	}
}
