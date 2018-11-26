package ProducerConsumer2;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class ProduerThread extends Thread {

	
	private final Exchanger<char[]> exchanger;
	private  char[] buffer=null;
	private final Random random;
	private static int cakeid=0;
	public ProduerThread(String name,Exchanger<char[]> exchanger,char [] buff,Long seed) {
		super(name);
		this.exchanger=exchanger;
		random=new Random(seed);
		this.buffer=buff;
	}
	
	
	public void run() {
		try {
			while(true) {
				//produce and send out
		    	 //fill the buffer 间或性生产资料
		    	 for(int i=0;i<buffer.length;i++) {
		    		 buffer[i]=nextChar();
		    		 System.out.println(Thread.currentThread().getName()+":"+buffer[i]+"->");
		    	 }
		    	 //swap for buffer
		    	 System.out.println(Thread.currentThread().getName()+"BEFORE EXCHANGE BUFFER");
		    	 buffer=exchanger.exchange(buffer);
		    	 System.out.println(Thread.currentThread().getName()+"AFTER EXCHANGE BUFFER");
		    	 
		    	 
		     }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	     
	}
	
private char nextChar() throws InterruptedException {
	char c=(char)('A'+cakeid%26);
	cakeid++;
	Thread.sleep(random.nextInt(1000));
	return c;
}
}
