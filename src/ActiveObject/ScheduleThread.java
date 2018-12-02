package ActiveObject;

public class ScheduleThread  extends Thread{

	
	private final ActivationQueue thread_queue;
	public ScheduleThread(ActivationQueue queue) {
		this.thread_queue=queue;
	}
	
	//�ڶ���֮�м����´�����request����
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
