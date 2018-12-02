package ActObj2;

import java.util.concurrent.Future;

public class ClientThread  extends Thread{

	private final ActiveObject object;
	private char fillchar;
	public ClientThread(String name,ActiveObject obj) {
		super(name);
		this.object=obj;
		fillchar=name.charAt(0);
	}
	
	
	public void run() {
		
		try {
			
			for(int i=0;true;i++) {
				Future<String> future=object.makeStr(i,fillchar);
				Thread.sleep(10);
				System.out.println(currentThread().getName()+" makes string "+future.get());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
