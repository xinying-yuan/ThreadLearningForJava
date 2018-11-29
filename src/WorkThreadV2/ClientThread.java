package WorkThreadV2;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

public class ClientThread  extends Thread{

	private final ExecutorService service;
	public ClientThread(String name,ExecutorService eService) {
		super(name);
		this.service=eService;
	}
	public void run() {
	   try {
		   for(int i=0;true;i++) {
				Request request=new Request(getName(),i+"");
				service.execute(request);
			
			    Thread.sleep(new Random().nextInt(10));
				
			}
	     } catch (InterruptedException e) {
		// TODO: handle exception
	    	 e.printStackTrace();
	      }catch(RejectedExecutionException e) {
	    	  System.out.println(Thread.currentThread().getName()+":"+e);
	      }
		
	}
}
