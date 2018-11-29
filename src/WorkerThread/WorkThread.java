package WorkerThread;

import java.util.Random;

public class WorkThread  extends Thread{
	//���ϵĲ���request����
	private final Channel channel;
	public WorkThread(String name,Channel channel) {
		super(name);
		this.channel=channel;
	}
	
	public void run() {
		while(true) {
			//���ϵļ��channel�Ƿ����µ�����������У����������ѭ���ȴ�
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
