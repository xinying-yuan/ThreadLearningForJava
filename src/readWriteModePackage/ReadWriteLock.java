package readWriteModePackage;

public class ReadWriteLock {
	private int readingThread=0;//正在等待的读线程的数量
	private int writingThread=0;//正在写线程的数量
	private int waitingThread=0;//正在等待的写线程的数量
	private boolean writeFirst=true;//默认是写线程优先执行

	//unlock方法执行的时候需要notifyall来同步变化
	public synchronized void readlock() throws InterruptedException{
		//读写互斥  写者优先
		while(writingThread>0||(writeFirst&&waitingThread>0)) {
			wait();
		}
		readingThread++;
	}
	public synchronized void readUnlock() {
		readingThread--;
		writeFirst=true;
		notifyAll();
	}
	public synchronized void writelock()  throws InterruptedException{
		waitingThread++;
		try {
			//如果已经有线程在读或者有线程在写 就等待
			while(readingThread>0||writingThread>0) {
				wait();
			}
		} finally {
			// TODO: handle finally clause
			waitingThread--;
		}
		writingThread++;
	}
	public synchronized void writeUnlock() {
		writingThread--;
		writeFirst=false;
		notifyAll();
	}
	//假设程序中没有WriteFirst这个字段以及waitingThread的这个字段会发生什么情况？
	//readThread一旦运行就会源源不断，writeThread将失去运行的机会
	//如果仅有waiting这个字段就会导致一旦有writeThread运行readThread便会失去运行的机会
	//加上了writeFirst字段，并且readThread在运行之后会自动将其设置成为true，将运行的主导权交给writethread
	//而writeThread在运行结束之后会将writefirst设置成为false，将运行的主导权交给readThread
	//迄今为止见过的最美代码。。。
}
