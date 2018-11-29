<<<<<<< HEAD
package ReadWriteModel;

public class Main {

		
	public static void main(String[] args) {
		
		Data data=new Data(10);
		new ReadThread("reader1", data).start();
		new ReadThread("reader2", data).start();
		new ReadThread("reader3", data).start();
		new ReadThread("reader4", data).start();
		new WriteThread("writer1", data, "ABCDEFGHIJKLMNOPQRSTUVWXYZ").start();
		new WriteThread("writer2", data, "abcdefghijklmnopqrstuvwxyz").start();
		
	}
}
=======
package ReadWriteModel;

public class Main {

		
	public static void main(String[] args) {
		
		Data data=new Data(10);
		new ReadThread("reader1", data).start();
		new ReadThread("reader2", data).start();
		new ReadThread("reader3", data).start();
		new ReadThread("reader4", data).start();
		new WriteThread("writer1", data, "ABCDEFGHIJKLMNOPQRSTUVWXYZ").start();
		new WriteThread("writer2", data, "abcdefghijklmnopqrstuvwxyz").start();
		
	}
}
>>>>>>> 5cd2fd3ecec5025f95c74093552dc9073f6f82eb
