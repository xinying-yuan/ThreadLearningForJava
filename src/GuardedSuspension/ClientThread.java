package GuardedSuspension;

import java.util.Random;

public class ClientThread  extends Thread{

	private final Random random;
	private final String thread_name;
	private final RequestQueue requestQueue;
	public ClientThread(String name,RequestQueue queue,long seed) {
		super(name);
		this.thread_name=name;
		random=new Random(seed);
		this.requestQueue=queue;
		
	}
	public void run() {
		for(int i=0;i<1000;i++) {
			Request request=new Request(i+"");
			requestQueue.putRequest(request);
			System.out.println(Thread.currentThread().getName()+" put request"+request+"into request queue");
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
