package Immutable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import Immutable.writeThread;
import Immutable.readThread;
public class CopyOnWrite {
	//���ַ����Ƚϰ�ȫ������������дʱ���ƣ����������Ч�����ǳ���
	//�����ڳ�����Ĵ����ǳ��൫��д�Ĵ����ǳ��ٵ��龰��ʹ��
	public static void main(String[] args) {
		List<Integer> list=new CopyOnWriteArrayList<Integer>();
		new writeThread(list).start();
		new readThread(list).start();
	}
}
