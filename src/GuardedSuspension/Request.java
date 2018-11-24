package GuardedSuspension;

import com.sun.security.ntlm.Client;

public class Request {

	private final String request_name;
	public Request(String name) {
		this.request_name=name;
	}
	public String getName() {
		return  this.request_name;
	}
	public String toString() {
		return "["+request_name+"]";
	}
	
	
	//sleep 不会释放锁，但是wait方法会释放锁资源；
	public static void main(String[] args) {
		RequestQueue queue=new RequestQueue();
		new ClientThread("client", queue, 6553567L).start();
		new ServerThread("server", queue, 3152673L).start();
	}
}
