package futuremodel;

import java.util.Random;

public class RealData implements Data {
		
	private char[] buffer;
	private String content;
	public RealData(int count ,char c) {
		// TODO Auto-generated constructor stub
		System.out.println("@~~~~~~~~~~~~~~~@making request"+count+ " "+c+"begin");
		buffer=new char[count];
		for(int i=0;i<count;i++) {
			buffer[i]=c;
			try {
				Thread.sleep(new Random().nextInt(1000));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		content=String.valueOf(buffer);
		System.out.println("@~~~~~~~~~~~~~~~@making request"+count+ " "+c+"end");
		
	}
	public String getContent() {
		return String.valueOf(buffer);
	}
}
