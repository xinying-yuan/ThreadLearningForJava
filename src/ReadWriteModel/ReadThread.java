package ReadWriteModel;

public class ReadThread extends Thread {

	 final private Data data;
	public ReadThread(String name,Data data) {
		// TODO Auto-generated constructor stub
		super(name);
		this.data=data;
	}
	
	
	public void run() {
		while(true) {
			//read the data content and print it
			try {
				char[] res=data.read();
				System.out.println(currentThread().getName()+"is reading "+String.valueOf(res));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch blocks
				e.printStackTrace();
			}
			
		}
	}
}
