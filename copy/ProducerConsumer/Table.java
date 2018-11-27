package ProducerConsumer;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class Table {
//capacity =3
//maker�� tail��ʼ�ŵ���
//consumer ��head��ʼȡ����
//count��ʾ��ǰ�����Ͽ�ʳ�õ������	
	final int capacity;
	private int tail=0;
	private int head=0;
	private int count=0;
	private String[] cakes;
	public Table(int cap) {
		this.capacity=cap;
		cakes=new String[cap];
	}
	
	//������������õ���
	public synchronized void putCakes(String newcake) throws InterruptedException {
		while(count>=capacity) {
			wait();
		}
		cakes[tail]=newcake;
		tail=(tail+1)%capacity;
		count++;
		notifyAll();
	}
	//������������ȡ����
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
