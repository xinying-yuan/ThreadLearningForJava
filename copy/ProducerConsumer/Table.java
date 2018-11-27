package ProducerConsumer;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class Table {
//capacity =3
//maker从 tail开始放蛋糕
//consumer 从head开始取蛋糕
//count表示当前桌子上可食用蛋糕个数	
	final int capacity;
	private int tail=0;
	private int head=0;
	private int count=0;
	private String[] cakes;
	public Table(int cap) {
		this.capacity=cap;
		cakes=new String[cap];
	}
	
	//在桌子上面放置蛋糕
	public synchronized void putCakes(String newcake) throws InterruptedException {
		while(count>=capacity) {
			wait();
		}
		cakes[tail]=newcake;
		tail=(tail+1)%capacity;
		count++;
		notifyAll();
	}
	//从桌子上面拿取蛋糕
	public synchronized String takeCake() throws InterruptedException {
		while(count<=0) {
			//no cakes sad
			wait();
		}
		String cake=cakes[head];
		head=(head+1)%capacity;
		count--;
		notifyAll();
		return cake;
	}
	
}
