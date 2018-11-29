package WorkThreadV2;

import java.util.Random;

public class Request implements Runnable{

	private String name;
	private String number;
	public Request(String name,String number) {
		this.name=name;
		this.number=number;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName()+" executes "+this);
		try {
			Thread.sleep(new Random().nextInt(1000));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public String toString() {
		return "[request from"+name+" No."+number+"]";
	}
}
