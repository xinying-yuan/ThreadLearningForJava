package twophaseTermination;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.sun.org.apache.xml.internal.serialize.Printer;

import readWriteModePackage.ThinkForThis;

public class Main {

	private final static int threads_count=3;
	public static void main(String[] args) {
		System.out.println("main starts");
//		test1();
//		test2();
//		test3();
		Thread thread=new Thread()
				{
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					while(true) {
						try {
							if(Thread.interrupted()) {
								throw new InterruptedException();
							}
							System.out.println("@");
						} catch (Exception e) {
							// TODO: handle exception
							while(true) {
								System.out.println("#");
							}
							
						}
					}
						
						
					}};
		thread.start();
		try {
			Thread.sleep(5000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread.interrupt();
        System.out.println("end of main");
         
		//System.out.println("main ends");
	}
	
	public static  void test3() {
		//汉诺塔
		try {
		   HanoiThread hanoiThread=new HanoiThread();
		   hanoiThread.start();

			Thread.sleep(6000);
			System.out.println("shut down request by main");
			hanoiThread.shutDown();
			hanoiThread.join();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	}
	public static void test2() {
		//test for cyclicbarrier and countdownlatch
		Runnable barrierAction=new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("barrier has 3 threads waiting to be executes");
			}
		};
		
		CyclicBarrier barrier=new CyclicBarrier(3,barrierAction);
		//在同时有三个线程在等待执行的时候，barrier会自动调用action的run方法输出调试信息
		CountDownLatch latch=new CountDownLatch(threads_count);
		ExecutorService service=Executors.newFixedThreadPool(3);
		try {
			for(int t=0;t<threads_count;t++) {
				service.execute(new Mytask(barrier, latch, t));
			}
			System.out.println("await");
			latch.await();
			//直到所有的线程都执行完毕 count=0
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			// TODO: handle finally clause
			service.shutdown();
			System.out.println("end");
		}
	
	}
	public static void  test1() {
		
		System.out.println("Main begin");
		try {
			CountupThread countupThread=new CountupThread();
			countupThread.start();
			
			Thread.sleep(10000);
			
			System.out.println("shudown request begin");
			countupThread.shutdownRequest();
			System.out.println("shudown request ends");
			
			System.out.println("join begin");
			countupThread.join();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
