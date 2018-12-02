package ActiveObject;

//producer-consumer 中的table
public class ActivationQueue {

 private int head;
 private int tail;
 private int count;
 private static final int MAX_REQUEST=100;
// private final MakingRequest<String>[] buffer;
 private final MakingRequest[] buffer;
 //两种写法都可以
 public ActivationQueue() {
	 this.head=0;
	 this.tail=0;
	 this.count=0;
     buffer=new MakingRequest[MAX_REQUEST];
 }
 
 public synchronized void  putRequest(MakingRequest<String> request) {
     while(count>=MAX_REQUEST) {
    	 try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     buffer[tail]=request;
     tail=(tail+1)%MAX_REQUEST;
     count++;
     notifyAll();
 }
 
 public synchronized MakingRequest<String>  getRequest() {
	 
	 while(count<=0) {
		 try {
			wait();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 }
	 MakingRequest<String> result=buffer[head];
	 head=(head+1)%MAX_REQUEST;
	 count--;
	 notifyAll();
	 return result;
 }
}
