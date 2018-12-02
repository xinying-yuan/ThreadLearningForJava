package ActiveObject;

public abstract class MakingRequest<T> {
     
	protected final FutureResult<T> futureResult;
	protected final Servant servant;
	public MakingRequest(FutureResult<T> future,Servant servant) {
		this.futureResult=future;
		this.servant=servant;
	}
	public abstract void execute();
	
}
