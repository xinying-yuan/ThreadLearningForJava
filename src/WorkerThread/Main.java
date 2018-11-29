package WorkerThread;

public class Main {

	public static void main(String[] args) {
		Channel channel=new Channel(5);
		channel.startAllWorkers();
		
		new ClientThread(channel, "client1").start();
		new ClientThread(channel, "client2").start();
		new ClientThread(channel, "client3").start();
	}
}
