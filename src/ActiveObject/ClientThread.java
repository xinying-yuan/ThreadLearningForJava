package ActiveObject;

public class ClientThread  extends Thread{

	private activeObject object;
	private char fillchar;
	public ClientThread(String name,activeObject obj) {
		super(name);
		this.object=obj;
		fillchar=name.charAt(0);
	}
	public void run() {
		try {
			for(int i=0;true;i++) {
				Result<String> result=object.makeString(i, this.fillchar);
				Thread.sleep(10);
				String value=result.getResultValue();
				System.out.println(Thread.currentThread().getName()+":value= "+ value);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
