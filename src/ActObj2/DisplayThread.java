package ActObj2;

public class DisplayThread  extends Thread{

	private final ActiveObject object;
	public DisplayThread(String name,ActiveObject obj) {
		super(name);
		this.object=obj;
	}
	
	
	public void run() {
	  try {
		for(int i=0;true;i++) {
			String string=currentThread().getName()+" display i ="+i;
			object.display(string);
			Thread.sleep(200);
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	}
}
