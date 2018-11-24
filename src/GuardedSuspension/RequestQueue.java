package GuardedSuspension;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class RequestQueue {

	////这里的LinkedList属于mutable类，所以在get和put方法上面都要加上synchronized关键字来保证线程访问安全
	//getRequest
	private final Queue<Request> queue=new LinkedList<Request>();
	//线程安全类  
	private final BlockingQueue<Request> queue2=new LinkedBlockingQueue<Request>();
	
	//guard condition  queue.peek!=null
	public synchronized Request getRequest() {
		while(queue.peek()==null) {
			try {
				System.out.println("empty in request queue!!!!!!!");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 return queue.remove();
	}
	
	
//	public Request getRequest2(){
//		Request request=null;
//		try {
//			request=queue2.take();
//		}catch(InterruptedException e) {
//			e.printStackTrace();
//		}
//		return request;
//	}
	//此处的take方法在 队列为空的时候会自动调用wait方法进行等待
	
	
	//putRequest
	public synchronized void putRequest(Request request) {
		queue.offer(request);
		//queue.put(request); for LinkedBlokcingQueue;
		notifyAll();
	}
}
