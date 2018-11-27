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

//由于在writethread中显示调用了list的add方法和remove方法，而传进去的参数本身就是concurrent并发支持的，所以不需要改变writethread中的结构
//而在readThread2中，由于隐式地调用了我们的迭代器方法，来修改list中的数值，所以需要对迭代器的访问加上关键字 锁
//writethread中的 add有锁 remove有锁但是readThread中迭代器访问并没有上锁。等待writeThread被唤醒之后就无需抢占锁资源也能够进行value的修改
//所以和这里的迭代器对于值得修改产生了冲突
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