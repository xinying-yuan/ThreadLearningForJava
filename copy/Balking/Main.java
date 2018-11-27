package Balking;

public class Main {

 public static void main(String[] args) {
	Data data=new Data("file.txt", "init content");
	new ChangeThread("ChangeThread", data,5629387L).start();
	new SaveThread("SaveThread", data, 1672839L).start();
}
}
