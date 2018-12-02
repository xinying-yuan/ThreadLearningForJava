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
		}
		return log;
	}
}
