package futuremodel;

import java.util.concurrent.ExecutionException;

public abstract interface Data{
	public abstract String getContent() throws ExecutionException;
}