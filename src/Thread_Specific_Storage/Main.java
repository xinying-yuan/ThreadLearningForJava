package Thread_Specific_Storage;

public class Main {

	public static void main(String[] args) {
		new ClientThread("alice").start();
		new ClientThread("bob").start();
		new ClientThread("chris").start();
	}
	
//	most important obj to implement Thread_Specific_Storage is using ThreadLocal
//  ThreadLocal stores specific obj for thread using (key,value) 
//  key = Thread.currentThread()
//  if set() method is not called then get() method return null because there is no obj in the box
}
