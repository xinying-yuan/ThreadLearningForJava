package ActiveObject;

public class ScheduleThread  extends Thread{

	
	private final ActivationQueue thread_queue;
	public ScheduleThread(ActivationQueue queue) {
		this.thread_queue=queue;
	}
	
	//在队列之中加入新创建的request对象
	public void invoke(MakingRequest request) {
		thread_queue.putRequest(request);
	}
	public void run() {
		while(true) {
			MakingRequest request=thread_queue.getRequest();
			request.execute();
		}
	}
}
