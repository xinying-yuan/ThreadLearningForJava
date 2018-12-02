package ActObj2;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ActiveObjectImpl implements ActiveObject {

	private final ExecutorService service =Executors.newSingleThreadExecutor();
	
	public Future<String> makeStr( final int count, final char c){
		//service.submit(callable) 返回值是future类型的
		class makeStringRequest implements Callable<String>{
			public String call() {
				char[] buffer=new char[count];
				for(int i=0;i<count;i++) {
					buffer[i]=c;
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				return new String(buffer);
			}
		}
		
		
		return service.submit(new makeStringRequest());
	}
	public void display(String s) {
		//sevice.execute(runnable)
		
		class DisStr implements Runnable{
				public void run() {
					try {
						System.out.println("display string"+s);
					    Thread.sleep(10);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
		}
		service.execute(new DisStr());
	}
	public void shutdown() {
		service.shutdown();
	}

}
