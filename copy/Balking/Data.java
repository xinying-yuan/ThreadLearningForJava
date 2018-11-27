package Balking;

import java.io.FileWriter;
import java.io.IOException;

import java.io.Writer;

public class Data {

	private final  String file_path;
	private String content="";
	private boolean changed=false;
	
	public Data(String file_path,String Content) {
		this.file_path=file_path;
		this.content=Content;
	}
	
	public synchronized void change(String newcontent) {
		if(content.equals(newcontent)) return;
		changed=true;
		content=newcontent;
	}
	
	public synchronized void save() throws IOException {
		if(!changed) 
			{
			System.out.println(Thread.currentThread().getName()+" return from save method");
			return;
			}
		//守护条件，如果文章内容没有改变，那么线程直接返回即可，不用guard
		//System.out.println(Thread.currentThread().getName()+" call the doSave"+"  content="+content);
		doSave();
		changed=false;
		
	}
	//由于doSave方法的可见性为private，在这里仅仅被save方法调用，所以是线程安全的
	private void doSave() throws IOException {
		//System.out.println("update content in file"+file_path);
		Writer  writer=new FileWriter(file_path);
		writer.write(content);
		writer.close();
		//System.out.println("content has been updated");
	}
}
