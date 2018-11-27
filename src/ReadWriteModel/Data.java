package ReadWriteModel;
public class Data {

	final private char[] buffer;
	final private ReadWriteLock lock;
	final private int len;
	public Data(int len) {
		this.len=len;
		buffer=new char[len];
		init();
		lock=new ReadWriteLock();
	}
	private void init() {
		for(int i=0;i<len;i++) {
			buffer[i]='*';
		}
	}
	public char[] read() throws InterruptedException
	{
		lock.readlock();
		try {
			return doRead();
		} finally {
			// TODO: handle finally clause
			lock.readUnlock();
		}
	}
	public void write(char c) throws InterruptedException {
		lock.writelock();
		try {
			doWrite(c);
		} finally {
			// TODO: handle finally clause
			lock.writeUnlock();
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
