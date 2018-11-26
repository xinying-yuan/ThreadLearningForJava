package Immutable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import Immutable.writeThread;
import Immutable.readThread;
public class CopyOnWrite {
	//这种方法比较安全，但是由于是写时复制，程序的运行效果会差非常多
	//适用于程序读的次数非常多但是写的次数非常少的情景下使用
	public static void main(String[] args) {
		List<Integer> list=new CopyOnWriteArrayList<Integer>();
		new writeThread(list).start();
		new readThread(list).start();
	}
}
