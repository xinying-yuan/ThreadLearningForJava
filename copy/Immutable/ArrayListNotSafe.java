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
//ArrayList�ࣨ�Լ�������)�ڱ�����߳�ͬʱ��д��ʧȥ��ȫ�Ե�ʱ�򣬱���׳�concurrentmodificationexception�쳣
//����������У�write�̲߳��ϵ���arraylist��д������ ��read�߳�Ҳͬʱ��ȡ����list�ĵ������������㱻ϵͳ������дд�쳣����
//for(int n:list) = Iterator<Integer> it=list.iterator()  while(it.hasNext())... int n=it.next()
//ǰ���д���Ƚϼ��
//�����е�ArrayList��û���ṩ�����ƣ�������add��read�еĵ���������ͬ���߳�ʹ�õ�ʱ�����׳��쳣��Ϣ
