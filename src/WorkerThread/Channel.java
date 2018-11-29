package WorkerThread;

public class Channel {

	//request array to load requests from cleintThread
	//workthread array to hold the work threads
	//tail to place request
	//head to take request
	//count to imply the reming request number
	private final static int MAX_COUNT=100;//最大容量
	private final Request[] requestQueue;
	private final WorkThread[] threadPool;
	private int tail=0;
	private int head=0;
	private int count=0;
	public Channel(int count) {
		threadPool=new WorkThread[count];
		requestQueue=new Request[MAX_COUNT];
		for(int i=0;i<count;i++) {
			WorkThread thread=new WorkThread("worker"+i,this);
			threadPool[i]=thread;
		}
	}
	
	public void startAllWorkers() {
		for(int i=0;i<threadPool.length;i++) {
			threadPool[i].start();
		}
	}
	public  synchronized  void putRequest(Request request) {
		while(count>=MAX_COUNT) {
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		requestQueue[tail]=request;
		tail=(tail+1)%MAX_COUNT;
		count++;
		notifyAll();
		
	}

	public synchronized Request takeRequest() {
		//检查count是否在取值范围内
		while(count<=0) {
			//余量不足则等待
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//有余粮了，叫醒工人执行线程
		Request request=requestQueue[head];
		head=(head+1)%MAX_COUNT;
		count--;
		notifyAll();
		return request;
	}
	
}
