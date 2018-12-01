package twophaseTermination;

public class CountupThread  extends Thread{

	private int count=0;
	private  volatile boolean shutdownRequest=false;
	
	public void run() {
		try {
			while(!isshutdownRequested()) {
				doWork();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			//do nothing with sleep method
		}finally {
			shutdown();
		}
		
	}
	
	public boolean isshutdownRequested() {
		return shutdownRequest;
	}
	public void shutdownRequest() {
		this.shutdownRequest=true;
		interrupt();
	}
	
	public void doWork() throws InterruptedException {
		count++;
		System.out.println("woking method count= "+count);
		sleep(500);
	}
	public void shutdown() {
		System.out.println("shudong method count="+count);
	}
}
