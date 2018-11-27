package GuardedSuspension;

import java.util.Random;

public class ServerThread  extends Thread{
	
	private String thread_name;
	final RequestQueue queue;
	final Random random;
	public ServerThread(String name,RequestQueue queue,long seed) {
		// TODO Auto-generated constructor stub
		super(name);
		this.thread_name=name;
		this.queue=queue;
		random=new Random(seed);
	}
	
	public void run() {
		for(int i=0;i<1000;i++) {
			Request request=queue.getRequest();
			System.out.println(Thread.currentThread().getName()+" take request"+request+"from request queue");
			try {
				Thread.sleep(random.nextInt(800));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
