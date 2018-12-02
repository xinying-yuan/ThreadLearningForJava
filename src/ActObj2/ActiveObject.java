package ActObj2;
import java.util.concurrent.Future;

public interface ActiveObject {
public abstract Future<String>  makeStr(int count,char fillchar);
public abstract void display(String s);
public abstract void shutdown();
}
