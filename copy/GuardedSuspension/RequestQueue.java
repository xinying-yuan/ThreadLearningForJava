package GuardedSuspension;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class RequestQueue {

	////�����LinkedList����mutable�࣬������get��put�������涼Ҫ����synchronized�ؼ�������֤�̷߳��ʰ�ȫ
	//getRequest
	private final Queue<Request> queue=new LinkedList<Request>();
	//�̰߳�ȫ��  
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
	//�˴���take������ ����Ϊ�յ�ʱ����Զ�����wait�������еȴ�
	
	
	//putRequest
	public synchronized void putRequest(Request request) {
		queue.offer(request);
		//queue.put(request); for LinkedBlokcingQueue;
		notifyAll();
	}
}
