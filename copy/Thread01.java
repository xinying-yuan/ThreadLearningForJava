
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
public class Thread01 {

	
	//创建线程的几种方法
	public static void main(String[] args) {
	   // ThreadFactory tFactory=Executors.defaultThreadFactory();
	  //  tFactory.newThread(new printer2("good")).start();
	  //  tFactory.newThread(new printer2("nice")).start();
	 //   new Thread(new printer2("good")).start();
	 //   new Thread(new printer2("nice")).start();
		  System.out.println("end of main thread");
	}
}

class printer2 implements Runnable{
	String message="";
	public printer2(String message) {
		// TODO Auto-generated constructor stub
		this.message=message;
	}@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<1000;i++) {
			System.out.println(message);
		}
	}
}
class printer extends Thread{
	String message="";
	
	public printer(String message) {
		this.message=message;
	}
	
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.print(message);
		}
 
   }
}