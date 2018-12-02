package ActiveObject;

public class FutureResult<T> extends Result<T> {

	
	private boolean ready=false;
	private Result<T> result=null;
	
	public synchronized void setValue(Result<T> result) {
		this.result=result;
		this.ready=true;
		notifyAll();
	}
	public  synchronized T getResultValue() {
		while(!ready) {
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return result.getResultValue();
	}
}
