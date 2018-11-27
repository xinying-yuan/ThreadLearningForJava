package ReadWriteModel;

import java.util.Random;

public class WriteThread extends Thread {

	final private Data data;
    private int index=0;
	final private String filter;
	final private Random random =new Random();
	public WriteThread(String name,Data data,String patter) {
		super(name);
		this.data=data;
		this.filter=patter;
	}
	public void run() {
		while(true) {
			char res=getNext();
			try {
				data.write(res);
				Thread.sleep(random.nextInt(3000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public char getNext() {
		char res=filter.charAt(index);
		index++;
		if(index>=filter.length()) {
			index=0;
		}
		return res;
	}
}
