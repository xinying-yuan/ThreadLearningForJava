package ActObj2;

public class ActiveObjectFactory {

	public static ActiveObject createActiveObject() {
		return new ActiveObjectImpl();
	}
}
