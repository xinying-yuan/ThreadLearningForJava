package futuremodel;

import java.util.concurrent.Callable;

public class Host {

	public Data request(int count,char c) {
		
		System.out.println("   request begins");
		final FutureData future=new FutureData();
		
		
		//method one 原生future data 自己实现
		/*new Thread() {
			
			public void run() {
				RealData data=new RealData(count, c);
				//在初始化完毕之后才能够执行下面的setRealData的代码从而在future中唤醒因为ready而阻塞的线程getContent
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
		//使用start方法的同时会自动调用传入的callable的call()方法 从而调用RealData的构造器 
		
		System.out.println("   request ends");
		
		return futureData2;
	}
}
