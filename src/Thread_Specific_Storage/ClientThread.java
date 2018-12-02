package Thread_Specific_Storage;

public class ClientThread extends Thread {

	public ClientThread(String name) {
		super(name);
	}
	
	public void run() {
		//using Log function to print info to the console
		System.out.println(currentThread().getName()+ "  starts");
		for(int i=0;i<10;i++) {
			Log.println("i="+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Log.close();
		System.out.println(currentThread().getName()+ "   ends");
		
	}
}
