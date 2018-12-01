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
			//�ݹ���ȱȽϴ��ʱ����ڳ���shutdown����Ĵ���ʱ��ͻ��������Ϊ������ȴ�dowork��ִ�����֮���ٻص�forѭ����ִ��
			//��ʱ��Ҫ��ǰ����������ʱ��Ļ���Ҫ�ڱȽϺ�ʱ�ĳ������ǰ������ж���価��������׳��쳣���ṩ��shutdown�������д���
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
