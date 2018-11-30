package futuremodel;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class FutureData2 extends FutureTask<RealData> implements Data {

	public FutureData2(Callable<RealData> callable) {
		super(callable);
	}
	
	
	//get方法会自动获取在futuredata2传入参数callable的call方法的返回值 
	//在本例子中也就是我们想要返回的realdata实例
	
	public String getContent() throws ExecutionException {
		String reString="";
		try {
			reString=get().getContent();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return reString;
	}
	
	
}
