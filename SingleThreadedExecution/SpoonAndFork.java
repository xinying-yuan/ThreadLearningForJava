package SingleThreadedExecution;

public class SpoonAndFork {

	
	//如果两个人按照相同的顺序来pick筷子和叉子就不会发生死锁的现象、
	//或者对spoon和fork组成的餐具整体加锁
	
	public static void main(String[] args) {
		Tool spoon=new Tool("spoon");
		Tool Fork=new Tool("Fork");
		Pair pair=new Pair(spoon, Fork);
		new CustomerThread("alice", pair).start();
		new CustomerThread("BOB", pair).start();
	}
}

class Tool{
	private String name;
	public Tool(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	public String toString() {
		return "["+name+"]";
	}
}

class Pair{
	private final Tool leftHand;
	private final Tool rightHand;
	public  Pair(Tool left,Tool right) {
		this.leftHand=left;
		this.rightHand=right;
	}
	public String toString() {
		return ""+leftHand+" and "+rightHand;
	}
}
class CustomerThread extends Thread{
	private  final String name;
	private final Pair pair;
//	private  final Tool LeftHand;
//	private  final Tool RightHand;
	public CustomerThread(String name,Pair pair) {
		// TODO Auto-generated constructor stub
		this.name=name;
//		this.LeftHand=left;
//		this.RightHand=right;
		this.pair=pair;
	}
	
	public void run() {
		while(true) {
			eat();
		}
	}
	public void eat() {
		
		
		synchronized(pair) {
			System.out.println(name+"pick up"+pair);
			System.out.println(name+"yum yum yum /1/1/");
			System.out.println(name+"put down "+pair);
		}
		
//		synchronized(LeftHand) {
//			    System.out.println(name+" get "+LeftHand+"in left hand");
//			synchronized(RightHand) {
//				System.out.println(name+" get "+RightHand+"in right hand");
//				System.out.println(name+"yum yum yum !");
//				System.out.println(name+"put down"+RightHand+"  in right hand");
//			}
//			System.out.println(name+" put down "+LeftHand+"  in left hand");
//		}
//		
		
	}
}