package ProducerConsumer;

public class Main {

	public static void main(String[] args) {
		Table table=new Table(3);
		new Producer("P1", table, 31415L).start();
		new Producer("P2", table, 92653L).start();
		new Producer("P3", table, 58979L).start();
		new Consumer("C1", table, 32384L).start();
		new Consumer("C2", table, 62643L).start();
		new Consumer("C3", table, 38327L).start();
	}
}
