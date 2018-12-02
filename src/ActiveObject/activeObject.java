package ActiveObject;

public interface activeObject {
	//company has two tasks services makestring and displaystring
	public abstract Result<String> makeString(int count,char fillchar);
	public abstract  void displayString(String s);

}
