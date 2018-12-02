package ActiveObject;

public class MakingStringRequest extends MakingRequest<String> {
	
	private int count;
	private char fillchar;
	
	public MakingStringRequest(FutureResult<String> future, Servant servant,int count,char fillchar) {
		super(future, servant);
		// TODO Auto-generated constructor stub
		this.count=count;
		this.fillchar=fillchar;
	}
	

	public void execute() {
		Result<String> result=servant.makeString(count, fillchar);
		futureResult.setValue(result);
	}

}
