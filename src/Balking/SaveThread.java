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
				//ÿ��һ�����һ���Զ��������
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
