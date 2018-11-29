package readWriteModePackage;

public class ReadWriteLock {
	private int readingThread=0;//���ڵȴ��Ķ��̵߳�����
	private int writingThread=0;//����д�̵߳�����
	private int waitingThread=0;//���ڵȴ���д�̵߳�����
	private boolean writeFirst=true;//Ĭ����д�߳�����ִ��

	//unlock����ִ�е�ʱ����Ҫnotifyall��ͬ���仯
	public synchronized void readlock() throws InterruptedException{
		//��д����  д������
		while(writingThread>0||(writeFirst&&waitingThread>0)) {
			wait();
		}
		readingThread++;
	}
	public synchronized void readUnlock() {
		readingThread--;
		writeFirst=true;
		notifyAll();
	}
	public synchronized void writelock()  throws InterruptedException{
		waitingThread++;
		try {
			//����Ѿ����߳��ڶ��������߳���д �͵ȴ�
			while(readingThread>0||writingThread>0) {
				wait();
			}
		} finally {
			// TODO: handle finally clause
			waitingThread--;
		}
		writingThread++;
	}
	public synchronized void writeUnlock() {
		writingThread--;
		writeFirst=false;
		notifyAll();
	}
	//���������û��WriteFirst����ֶ��Լ�waitingThread������ֶλᷢ��ʲô�����
	//readThreadһ�����оͻ�ԴԴ���ϣ�writeThread��ʧȥ���еĻ���
	//�������waiting����ֶξͻᵼ��һ����writeThread����readThread���ʧȥ���еĻ���
	//������writeFirst�ֶΣ�����readThread������֮����Զ��������ó�Ϊtrue�������е�����Ȩ����writethread
	//��writeThread�����н���֮��Ὣwritefirst���ó�Ϊfalse�������е�����Ȩ����readThread
	//����Ϊֹ�������������롣����
}
