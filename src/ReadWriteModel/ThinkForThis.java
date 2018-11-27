package ReadWriteModel;

public class ThinkForThis {
		private int readingThread=0;//正在等待的读线程的数量
		private int writingThread=0;//正在写线程的数量
		//unlock方法执行的时候需要notifyall来同步变化
		public synchronized void readlock() throws InterruptedException{
			//读写互斥  写者优先
			while(writingThread>0) {
				wait();
			}
			readingThread++;
		}
		public synchronized void readUnlock() {
			readingThread--;
			notifyAll();
		}
		public synchronized void writelock()  throws InterruptedException{
			
				//如果已经有线程在读或者有线程在写 就等待
				while(readingThread>0||writingThread>0) {
					wait();
				}
			
			writingThread++;
		}
		public synchronized void writeUnlock() {
			writingThread--;
			notifyAll();
		}
		
		//如果使用这种写法readThread一旦开始执行便不会让出资源给writeThread使用
}
