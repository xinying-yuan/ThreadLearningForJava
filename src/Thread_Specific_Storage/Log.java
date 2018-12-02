package Thread_Specific_Storage;

import java.lang.ThreadLocal;
public class Log {

   //using ThreadLocal to get control over different TSlog object
	private static final ThreadLocal<TSlog> manager=new ThreadLocal<TSlog>();
	
	public static void println(String s) {
	    getTSlog().println(s);
	}
	
	public static void close() {
		getTSlog().close();
	}
	
	private static TSlog getTSlog() {
		TSlog log= manager.get();
		
		if(log==null) {
			//create a new tslog and set
			log=new TSlog(Thread.currentThread().getName()+"-log.txt");
			manager.set(log);
		    startWatcher(log);
		}
		return log;
	}
	
	//no need for Log.close() method 
	private static void startWatcher(final TSlog log) {
		//close log in this method
		
		Thread obj=Thread.currentThread();
		System.out.println("start watching "+obj.getName());
		Thread watcher=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					obj.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				log.close();
				System.out.println("thread being watchered ends,log has been closed in watcher thread");
			}
		});
		watcher.start();
	}
}
