package Immutable;

import java.util.ArrayList;
import java.util.List;
public class ArrayListNotSafe {

	public static void main(String[] args) {
	  List<Integer> list=new ArrayList<Integer>();
	  new writeThread(list).start();
	  new readThread(list).start();
	  }
}

class writeThread extends Thread{
	private final List<Integer>  list;
	public writeThread(List<Integer> list) {
		super("write thread");
		this.list=list;
	}
	public void run() {
		
			for(int i=0;true;i++) {
			System.out.println("wirte");
			 list.add(i);
			 try {
				 Thread.sleep(100); 
			 }catch(Exception E) {
				 E.printStackTrace();
			 }
			 
			 
			 list.remove(0);
		}
	}
}
class readThread extends Thread{
	private final List<Integer> list;
	public readThread(List<Integer> list) {
		super("read List");
		this.list=list;
	}
	public void run() {
		while(true) {
			for(int n:list) {
				System.out.println(n);
			}
		}
	}
}
//ArrayList类（以及迭代器)在被多个线程同时读写而失去安全性的时候，便会抛出concurrentmodificationexception异常
//在这个例子中，write线程不断的向arraylist中写入数据 而read线程也同时获取到了list的迭代器操作，便被系统检测出有写写异常产生
//for(int n:list) = Iterator<Integer> it=list.iterator()  while(it.hasNext())... int n=it.next()
//前面的写法比较简洁
//本例中的ArrayList并没有提供锁机制，所以在add和read中的迭代器被不同的线程使用的时候便会抛出异常信息
