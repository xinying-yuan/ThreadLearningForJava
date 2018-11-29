package WorkerThread;

import java.util.Random;

public class Request {

	// composed of name and number
	private String name;
	private String number;
    public Request(String name,String number) {
    	this.name=name;
    	this.number=number;
    }
    
    //execute method 
    public void execute() {
    	//print the info of this obj
    	System.out.println(Thread.currentThread().getName()+"deal with "+this.toString());
    	try {
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public String toString() {
    	return "[request from :["+name+"], number is ["+number+"]]";
    }
}
