package futuremodel;

public class FutureData  implements Data{

    private RealData realData;
    private boolean ready=false;
    
	public synchronized void setRealData(RealData data) {
		
		if(ready) {
		  return;	
		}
		
		this.realData=data;
		ready=true;
		notifyAll();
	}
	
	public synchronized String getContent() {
		while(!ready) {
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return realData.getContent();
	}
}
