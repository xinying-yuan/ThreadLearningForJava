package WorkThreadV2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Main {

	public static void main(String[] args) {
		ExecutorService eService=Executors.newFixedThreadPool(5);
		new ClientThread("alice",eService).start();
		new ClientThread("bobby",eService).start();
		new ClientThread("cazy",eService).start();
		//finally executorService.shutdown();
	}
	
}
