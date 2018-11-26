package Balking;

import java.io.IOException;
import java.util.Random;

public class ChangeThread extends Thread {
	
	final private Data data;
	final private Random random;
	public ChangeThread(String threadname,Data data,Long seed) {
		super(threadname);
		this.data=data;
		random=new Random(seed);
	}
	
	public void run() {
		try {
			for(int i=0;true;i++) {
				data.change("content has changed to "+ i);
				Thread.sleep(random.nextInt(10));
				data.save();
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
