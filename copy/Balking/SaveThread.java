package Balking;

import java.io.IOException;
import java.util.Random;

public class SaveThread  extends Thread{
	
	private final Random random;
	private final Data data;
	public SaveThread(String name,Data data,Long seed) {
		super(name);
		random=new Random(seed);
		this.data=data;
	}

	public void run() {
		
		try {
			while(true) {
				data.save();
				Thread.sleep(1000);
				//每隔一秒进行一次自动保存操作
			}
			
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}
