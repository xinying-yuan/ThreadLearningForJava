package ActiveObject;

public class MakingDisplayRequest extends MakingRequest<Object> {

	private final String string;
	public MakingDisplayRequest(Servant servant,String s) {
		// TODO Auto-generated constructor stub
		super(null, servant);
		this.string=s;
	}
	public void execute() {
		servant.displayString(string);
	}
}
