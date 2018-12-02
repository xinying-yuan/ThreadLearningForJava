package Thread_Specific_Storage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TSlog {

	private PrintWriter writer=null;

	public TSlog(String filename) {
		try {
			writer=new PrintWriter(new FileWriter(filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void println(String s) {
		writer.println(s);
	}
	public void close() {
		writer.write("========end of log====");
		writer.close();
	}
}
