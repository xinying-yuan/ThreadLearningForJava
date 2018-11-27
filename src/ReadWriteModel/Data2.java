package ReadWriteModel;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
public class Data2 {

    //JAVA API的使用
	final private char[] buffer;
	final private ReadWriteLock lock;
	final private Lock readLock;
	final private Lock writeLock;
	final private int len;
	public Data2(int len) {
		this.len=len;
		buffer=new char[len];
		init();
		lock=new ReentrantReadWriteLock(true);
		readLock=lock.readLock();
		writeLock=lock.writeLock();
		
		
	}
	private void init() {
		for(int i=0;i<len;i++) {
			buffer[i]='*';
		}
	}
	public char[] read() throws InterruptedException
	{
		readLock.lock();
		try {
			return doRead();
		} finally {
			// TODO: handle finally clause
		readLock.unlock();
		}
	}
	public void write(char c) throws InterruptedException {
		writeLock.lock();
		try {
			doWrite(c);
		} finally {
			// TODO: handle finally clause
			writeLock.unlock();
		}
		
	}
	public char[] doRead() {
		
		//copy the content of the old char buffer to the new buffer
		char[] newbuffer=new char[len];
		for(int i=0;i<len;i++) {
			newbuffer[i]=buffer[i];
		}
		slowly();
		return newbuffer;
		//可以使用arrayCopy 待查证
	}
	public void doWrite(char c) {
		
		for(int i=0;i<len;i++) {
			buffer[i]=c;
			slowly();
		}
		return;
	}
	public void slowly() {
		try {
			Thread.sleep(30);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
