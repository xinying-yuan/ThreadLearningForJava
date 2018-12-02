package ActiveObject;

public class Main {

	public static void main(String[] args) {
		activeObject object=ActiveObjectFactory.createActiveObj();
		new ClientThread("Alice", object).start();
		new ClientThread("Bob", object).start();
		new DisplayThread("Chris", object).start();
	}
}
