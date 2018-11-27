package SingleThreadedExecution;

public class UserThread extends Thread {

	private final Gate gate;
	private final String name;
	private final String address;
	public UserThread(String name,String address,Gate gate) {
		this.address=address;
		this.name=name;
		this.gate=gate;
	}
	
	
	public void run() {
		System.out.println(name+"begin");
		while(true) {
			gate.pass(name, address);
		}
	}
	
	
}
