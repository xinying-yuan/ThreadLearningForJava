package twophaseTermination;

public class HanoiThread extends Thread {
  //graceful termination model
	private volatile boolean shutdown=false;
	private volatile long shutdownTime=0;
	
	public void run() {
		try {
			for(int level=0;!isShutDown();level++) {
				System.out.println("==========level"+level+"start");
				dowork(level,'A','B','C');
				System.out.println("");
				System.out.println("==========level"+level+"ends");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			// TODO: handle finally clause
			doShutDown();
		}
		
	}
	
	public boolean isShutDown() {
		return shutdown;
	}
	public void shutDown() {
		shutdownTime=System.currentTimeMillis();
		shutdown=true;
		interrupt();
	}
	public void dowork(int level,char a,char b,char c)  throws InterruptedException{
		
		if(level>0) {
			//递归深度比较大的时候对于程序shutdown命令的处理时间就会过长，因为程序会先从dowork中执行完毕之后再回到for循环中执行
			//此时需要提前跳出来减少时间的话就要在比较耗时的程序操作前面加上判断语句尽可能早的抛出异常来提供给shutdown方法进行处理
			if(isShutDown()) {
				throw new InterruptedException();
			}
			dowork(level-1, a, c, b);
			System.out.print(a+"->"+b+" ");
			dowork(level-1, b, c, a);
		}
		
	}
	public void doShutDown() {
		long time=System.currentTimeMillis()-shutdownTime;
		System.out.println("total time spending "+time);
	}
}
