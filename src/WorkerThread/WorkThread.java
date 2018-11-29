package WorkerThread;

import java.util.Random;

public class WorkThread  extends Thread{
	//不断的产生request对象
	private final Channel channel;
	public WorkThread(String name,Channel channel) {
		super(name);
		this.channel=channel;
	}
	
	public void run() {
		while(true) {
			//不断的检查channel是否有新的任务产生若有，则处理，否则就循环等待
			Request request=channel.takeRequest();
			request.execute();
			//System.out.println(request+" has been done");
			try {
				Thread.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
