package SingleThreadedExecution;

public class Gate {
	private String name="nobody";
	private String address="nowhere";
	private int count=0;
	@Override
	public synchronized String toString() {
		// TODO Auto-generated method stub
		return "count"+this.count+"  name:"+this.name+"   address:"+address;
	}
	//�����ͬ�� ��ĳ���̵߳���check������ʱ���������е��̻߳᲻��ִ��pass��������дname��address��ֵ
    public synchronized  void  pass(String name,String address) {
    	this.name=name;
    	this.address=address;
    	this.count++;	
    	check();
    }
    private void check() {
    	if(this.name.charAt(0)!=this.address.charAt(0)) {
    		System.out.println("~~~~~~~~~~~~~BROKEN AT "+toString());
    	}
    }
    
    //check��������ֻ��pass�����е����ˣ�����������˽�����͡����Կ��Բ��ü�synchronized�ؼ���
    //���Ƿ����е�tostringΪ���з��������ܰ������
}
