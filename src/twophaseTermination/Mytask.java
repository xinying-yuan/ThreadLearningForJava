package twophaseTermination;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;


public class Mytask implements Runnable {
	private final int PHASE=5;
	final CyclicBarrier barrier;
	final CountDownLatch latch;
	private int context;
	
	public Mytask(CyclicBarrier barrier,CountDownLatch latch,int context) {
		// TODO Auto-generated constructor stub
		this.barrier=barrier;
		this.latch=latch;
		this.context=context;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
		for(int i=0;i<PHASE;i++) {
			   doPhase(i);
			   //ÿһ���̶߳���ִ��5��dophase���� �� ֻ�е������߳�ͬʱִ�������������֮����ܼ���ִ����һ�����
			   barrier.await();
		}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (BrokenBarrierException e) {
			// TODO: handle exception
		}
		finally {
			latch.countDown();
		}
		
	}
	protected void doPhase(int phase) {
		String name=Thread.currentThread().getName();
		System.out.println(name+" mytask begin doing context="+context+"phase="+phase);
		try {
			Thread.sleep(new Random(314159).nextInt(2000));
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			System.out.println(name +"mytask end doing context="+context+"phase"+phase);
		}
		
	}

}
