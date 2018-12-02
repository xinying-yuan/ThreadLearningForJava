package ActiveObject;

public class Porxy  implements activeObject{

	private final ScheduleThread scheduleThread;
	private final Servant servant;
	public Porxy(ScheduleThread scheduleThread,Servant servant) {
		this.scheduleThread=scheduleThread;
		this.servant=servant;
	}
	public Result<String> makeString(int count,char fillchar){
		FutureResult<String> futureResult=new FutureResult<>();
		scheduleThread.invoke(new MakingStringRequest(futureResult,servant,count,fillchar));
		return futureResult;
	}
	public void displayString(String s) {
		
		scheduleThread.invoke(new MakingDisplayRequest(servant, s));
	}

}
