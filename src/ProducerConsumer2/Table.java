package ProducerConsumer2;

import java.util.concurrent.ArrayBlockingQueue;

public class Table extends ArrayBlockingQueue<String>{

	//concurrent support
	public Table(int cap) {
		super(cap);
	}
	
	public void put(String cake) throws InterruptedException{
		System.out.println(Thread.currentThread().getName()+"put ["+cake+"]");
		super.put(cake);
	}
	
	public String take() throws InterruptedException {
		String cake=super.take();
		System.out.println(Thread.currentThread().getName()+"takes ["+cake+"]");
		return cake;
	}
	
}
