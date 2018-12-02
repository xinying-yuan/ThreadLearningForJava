package ActiveObject;

import java.util.Random;

public class Servant implements activeObject {

	@Override
	public Result<String> makeString(int count ,char fillchar) {
		// TODO Auto-generated method stub
		char[] buffer=new char[count];
		for(int i=0;i<count;i++) {
			buffer[i]=fillchar;
			try {
				Thread.sleep(new Random().nextInt(2000));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return new RealResult<String>(String.valueOf(buffer));
	}

	@Override
	public void displayString(String s) {
		// TODO Auto-generated method stub
		System.out.println(s);
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	

}
