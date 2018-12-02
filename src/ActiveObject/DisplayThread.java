package ActiveObject;

public class DisplayThread extends Thread {

	private String diString;
	private activeObject object;
	public DisplayThread(String name,activeObject obj) {
	super(name);
	this.object=obj;
	}
	
	public void run() {
		
	
		try {
			for(int i=0;true;i++) {
				String string=currentThread().getName()+"  display "+i;
				object.displayString(string);
				Thread.sleep(200);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
