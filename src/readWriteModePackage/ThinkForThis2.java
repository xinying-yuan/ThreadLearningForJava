<<<<<<< HEAD
package ReadWriteModel;

public class ThinkForThis2 {
			private int readingThread=0;//���ڵȴ��Ķ��̵߳�����
			private int writingThread=0;//����д�̵߳�����
			private int waitingThread=0;
			//unlock����ִ�е�ʱ����Ҫnotifyall��ͬ���仯
			public synchronized void readlock() throws InterruptedException{
				//��д����  д������
				while(writingThread>0||waitingThread>0) {
					wait();
				}
				readingThread++;
			}
			public synchronized void readUnlock() {
				readingThread--;
				notifyAll();
			}
			public synchronized void writelock()  throws InterruptedException{
				  waitingThread++;
				  try {
					  while(readingThread>0||writingThread>0) {
							wait();
						}
					
				 } finally {
					// TODO: handle finally clause
					waitingThread--;
				  }
					//����Ѿ����߳��ڶ��������߳���д �͵ȴ�
					
				writingThread++;
			}
			public synchronized void writeUnlock() {
				writingThread--;
				notifyAll();
			}
			
			//ʹ������һ����writeThread�ڵȴ�readThread��ִ�в���
			//���Ƚ������ĳ��������ֶ�writeFirst��ʹ�ã���readunlock����writeunlock��ʱ�������������ִ��Ȩ�Ÿ��Է�ʹ��
			//��������Ϳ��Խ���ִ�в�������ˣ�


}
=======
package ReadWriteModel;

public class ThinkForThis2 {
			private int readingThread=0;//���ڵȴ��Ķ��̵߳�����
			private int writingThread=0;//����д�̵߳�����
			private int waitingThread=0;
			//unlock����ִ�е�ʱ����Ҫnotifyall��ͬ���仯
			public synchronized void readlock() throws InterruptedException{
				//��д����  д������
				while(writingThread>0||waitingThread>0) {
					wait();
				}
				readingThread++;
			}
			public synchronized void readUnlock() {
				readingThread--;
				notifyAll();
			}
			public synchronized void writelock()  throws InterruptedException{
				  waitingThread++;
				  try {
					  while(readingThread>0||writingThread>0) {
							wait();
						}
					
				 } finally {
					// TODO: handle finally clause
					waitingThread--;
				  }
					//����Ѿ����߳��ڶ��������߳���д �͵ȴ�
					
				writingThread++;
			}
			public synchronized void writeUnlock() {
				writingThread--;
				notifyAll();
			}
			
			//ʹ������һ����writeThread�ڵȴ�readThread��ִ�в���
			//���Ƚ������ĳ��������ֶ�writeFirst��ʹ�ã���readunlock����writeunlock��ʱ�������������ִ��Ȩ�Ÿ��Է�ʹ��
			//��������Ϳ��Խ���ִ�в�������ˣ�


}
>>>>>>> 5cd2fd3ecec5025f95c74093552dc9073f6f82eb
