package WorkerThread;import java.util.Random;

public class ClientThread extends Thread {

	private final Channel channel;
	
	public ClientThread(Channel channel,String name) {
		super(name);
		this.channel=channel;
	}
	
	public void run() {
      try {
    	  for(int i=0;true;i++) {
    	    	Request request=new Request(getName(),i+"");
    	    	channel.putRequest(request);
    	    	Thread.sleep(new Random().nextInt(1000));
    	    }
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
    
    
	}
}
