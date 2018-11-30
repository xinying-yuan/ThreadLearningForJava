package futuremodel;

import java.util.concurrent.ExecutionException;

public class Main {

	public static void main(String[] args) throws ExecutionException {
		System.out.println("Main BEGIN");
		Host host=new Host();
		Data data1=host.request(10, 'A');
		Data data2=host.request(20, 'B');
		Data data3=host.request(30, 'C');
		
		System.out.println("       Main begin other tasks");
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("       Main end other tasks");
		
		System.out.println("data1="+data1.getContent());
        System.out.println("data2="+data2.getContent());
        System.out.println("data3="+data3.getContent());
        
        
		System.out.println("MAIN END");
	}
}
