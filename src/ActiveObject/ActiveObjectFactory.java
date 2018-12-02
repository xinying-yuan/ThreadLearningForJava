package ActiveObject;

public class ActiveObjectFactory {

	public static activeObject createActiveObj() {
		ActivationQueue queue=new ActivationQueue();
		Servant servant=new Servant();
		ScheduleThread thread=new ScheduleThread(queue);
		Porxy porxy=new Porxy(thread, servant);
		thread.start();
		return porxy;
		}
}
