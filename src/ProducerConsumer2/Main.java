package ProducerConsumer2;

import java.util.concurrent.Exchanger;

public class Main {
	public static void main(String[] args) {
		
		Exchanger<char[]> exchanger=new Exchanger<char[]>();
		char[] buffer1=new char[10];
		char[] buffer2=new char[10];
		new ProduerThread("Producer",exchanger,buffer1,654295L).start();
		new ConsumerThread("Consumer", exchanger, buffer2, 127352L).start();
		
	}

}
