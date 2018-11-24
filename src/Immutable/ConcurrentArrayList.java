package Immutable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Immutable.writeThread;
public class ConcurrentArrayList {
public static void main(String[] args) {
	
	final List<Integer> list=Collections.synchronizedList(new ArrayList<Integer>());
	new writeThread(list).start();
	new readThread2(list).start();
}
}

//������writethread����ʾ������list��add������remove������������ȥ�Ĳ����������concurrent����֧�ֵģ����Բ���Ҫ�ı�writethread�еĽṹ
//����readThread2�У�������ʽ�ص��������ǵĵ��������������޸�list�е���ֵ��������Ҫ�Ե������ķ��ʼ��Ϲؼ��� ��
//writethread�е� add���� remove��������readThread�е��������ʲ�û���������ȴ�writeThread������֮���������ռ����ԴҲ�ܹ�����value���޸�
//���Ժ�����ĵ���������ֵ���޸Ĳ����˳�ͻ
class readThread2 extends Thread{
	final private List<Integer> list;
	public readThread2(List<Integer> list) {
		this.list=list;
	}
	public void run() {
		while(true) {
			synchronized (list) {
//				System.out.println("hello world");
				for(int n:list) {		
					System.out.println(n);
					
				}
		}
		
		}
	}
}