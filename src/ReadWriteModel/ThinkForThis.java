package ReadWriteModel;

public class ThinkForThis {
		private int readingThread=0;//���ڵȴ��Ķ��̵߳�����
		private int writingThread=0;//����д�̵߳�����
		//unlock����ִ�е�ʱ����Ҫnotifyall��ͬ���仯
		public synchronized void readlock() throws InterruptedException{
			//��д����  д������
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
			
				//����Ѿ����߳��ڶ��������߳���д �͵ȴ�
				while(readingThread>0||writingThread>0) {
					wait();
				}
			
			writingThread++;
		}
		public synchronized void writeUnlock() {
			writingThread--;
			notifyAll();
		}
		
		//���ʹ������д��readThreadһ����ʼִ�б㲻���ó���Դ��writeThreadʹ��
}
