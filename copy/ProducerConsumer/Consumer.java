package ProducerConsumer;

import java.util.Random;


public class Consumer extends Thread {

	
	private final Table table;
	private final Random random;
	
	public Consumer(String name,Table table,Long seed) {
		super(name);
		this.table=table;
		random=new Random(seed);
	}
	public void run() {
		try {
			while(true) {
				Thread.sleep(random.nextInt(1000));
				String cake=table.takeCake();
				System.out.println(currentThread().getName()+" consume "+cake);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
}
