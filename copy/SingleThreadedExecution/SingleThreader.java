package SingleThreadedExecution;

public class SingleThreader {
	//module 1 singleThreader Execution
	public static void main(String[] args) {
		Gate gate=new Gate();
		new UserThread("alice", "australia", gate).start();
		new UserThread("bob", "brzail", gate).start();
		new UserThread("tom", "turkey", gate).start();
//		System.out.println("tom".charAt(0)!="turkey".charAt(0));
	}

}

