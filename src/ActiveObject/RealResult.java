package ActiveObject;

public class RealResult<T> extends Result<T>{
	private final T content;
	public RealResult(T content) {
		this.content=content;
		
	}
	
	public T getResultValue() {
		return this.content;
	}
}
