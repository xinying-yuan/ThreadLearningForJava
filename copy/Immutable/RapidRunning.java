package Immutable;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class RapidRunning {
	
   private final static long call_times=1000000000L;
	
	public static void main(String[] args) {
		
		//trial("nosyn", call_times, new NoSynch());
		//trial("synchr", call_times, new Synch());
		NoSynch noSynch=new NoSynch("xinying");
		StringBuffer buffer=noSynch.getbuffer();
		buffer.replace(3, 5, "$#");
//		System.out.println(noSynch.getbuffer());
		int num=noSynch.getcount();
		num+=1;
		System.out.println(noSynch.getcount());
		
	}
	public static void trial(String name,long count,Object obj) {
	   System.out.print("Test Begin"+name);
	   long start_time=System.currentTimeMillis();
	   for(long i=0;i<count;i++) {
		   obj.toString();
	   }
	   System.out.println("Test end"+name);
	   System.out.println("time  spendings"+(System.currentTimeMillis()-start_time));
	}
}


class NoSynch{
	private String name="nosyn";
	private final int count=1000;
	private final StringBuffer buffer;
	public NoSynch(String info) {
		this.buffer=new StringBuffer("buffer"+info);
	}
	public StringBuffer getbuffer() {
		return this.buffer;
		//返回的是指向对象的指针函数
	}
	public int  getcount() {
		return this.count;
	}
	public String toString() {
		return "["+this.name+"]";
	}
}
class Synch{
	private String name="synch";
	
	public synchronized String toString() {
		return "["+this.name+"]";
	}
}
//实验中相差了3秒钟
