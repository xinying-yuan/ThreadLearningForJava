package ProducerConsumer;

import java.util.Random;

public class Producer extends Thread {
    private final Table table;
    private final Random random;
    //shared variable for all cake makers
    private static int cakeid=0;
	public Producer(String name,Table table,Long seed) {
		super(name);
		this.table=table;
		random=new Random(seed);
	}
	public void run() {
		try {
			while(true) {
				Thread.sleep(random.nextInt(1000));
				String newCake="[cake:"+addCake()+"]";
				System.out.println(currentThread().getName()+"put cake"+newCake+" on the table");
				table.putCakes(newCake);	
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	private static synchronized int addCake() {
		return cakeid++;
	}
}
