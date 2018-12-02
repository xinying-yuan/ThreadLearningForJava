package ActObj2;

public class Main {

	public static void main(String[] args) {
		ActiveObject object=ActiveObjectFactory.createActiveObject();
		try {
			new ClientThread("Alice", object).start();
			new ClientThread("Bob", object).start();
			new DisplayThread("Chris", object).start();
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		} 
		finally {
			// TODO: handle finally clause
			System.out.println("code shut down");
			object.shutdown();
		}
	
	}
}
