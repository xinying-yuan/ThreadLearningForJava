package ProducerConsumer2;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class ConsumerThread extends Thread {

	private final Exchanger<char[]> exchanger;
	private  char[] buffer=null;
	private final Random random;
	public ConsumerThread(String name,Exchanger<char[]> exchanger,char [] buff,Long seed) {
		super(name);
		this.exchanger=exchanger;
		random=new Random(seed);
		this.buffer=buff;
	}
	
	public void run() {
		try {
			while(true) {
				//get the buffer and consume
				System.out.println(Thread.currentThread().getName()+" before exchange");
				buffer=exchanger.exchange(buffer);
				System.out.println(Thread.currentThread().getName()+"after exchange");
				
				for(int i=0;i<buffer.length;i++) {
					System.out.println(Thread.currentThread().getName()+":$$$$$"+buffer[i]+"$$$");
					Thread.sleep(random.nextInt(1000));
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
