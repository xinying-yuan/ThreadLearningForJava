package readWriteModePackage;

public class ThinkForThis2 {
			private int readingThread=0;//正在等待的读线程的数量
			private int writingThread=0;//正在写线程的数量
			private int waitingThread=0;
			//unlock方法执行的时候需要notifyall来同步变化
			public synchronized void readlock() throws InterruptedException{
				//读写互斥  写者优先
				while(writingThread>0||waitingThread>0) {
					wait();
				}
				readingThread++;
			}
			public synchronized void readUnlock() {
				readingThread--;
				notifyAll();
			}
			public synchronized void writelock()  throws InterruptedException{
				  waitingThread++;
				  try {
					  while(readingThread>0||writingThread>0) {
							wait();
						}
					
				 } finally {
					// TODO: handle finally clause
					waitingThread--;
				  }
					//如果已经有线程在读或者有线程在写 就等待
					
				writingThread++;
			}
			public synchronized void writeUnlock() {
				writingThread--;
				notifyAll();
			}
			
			//使用这种一旦有writeThread在等待readThread就执行不了
			//而比较完美的程序在于字段writeFirst的使用，在readunlock或者writeunlock的时候会主动将优先执行权放给对方使用
			//这样程序就可以交替执行不会出错了！


}

