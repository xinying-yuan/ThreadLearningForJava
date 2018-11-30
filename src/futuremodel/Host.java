package futuremodel;

import java.util.concurrent.Callable;

public class Host {

	public Data request(int count,char c) {
		
		System.out.println("   request begins");
		final FutureData future=new FutureData();
		
		
		//method one ԭ��future data �Լ�ʵ��
		/*new Thread() {
			
			public void run() {
				RealData data=new RealData(count, c);
				//�ڳ�ʼ�����֮����ܹ�ִ�������setRealData�Ĵ���Ӷ���future�л�����Ϊready���������߳�getContent
				future.setRealData(data);
			}
		}.start();*/
		
		//java api using future Task
		FutureData2 futureData2=new FutureData2(new Callable<RealData>() {
			
			@Override
			public RealData call() throws Exception {
				// TODO Auto-generated method stub
				return new RealData(count, c);
			}
		});
		new Thread(futureData2).start();
		//ʹ��start������ͬʱ���Զ����ô����callable��call()���� �Ӷ�����RealData�Ĺ����� 
		
		System.out.println("   request ends");
		
		return futureData2;
	}
}
