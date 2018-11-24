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
	//如果不同步 在某个线程调用check方法的时候，其余运行的线程会不断执行pass方法来改写name和address的值
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
    
    //check方法由于只在pass方法中调用了，并且属性是私有类型。所以可以不用加synchronized关键字
    //但是方法中的tostring为共有方法，可能包外调用
}
