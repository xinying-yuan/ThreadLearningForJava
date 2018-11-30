package futuremodel;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class FutureData2 extends FutureTask<RealData> implements Data {

	public FutureData2(Callable<RealData> callable) {
		super(callable);
	}
	
	
	//get�������Զ���ȡ��futuredata2�������callable��call�����ķ���ֵ 
	//�ڱ�������Ҳ����������Ҫ���ص�realdataʵ��
	
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
