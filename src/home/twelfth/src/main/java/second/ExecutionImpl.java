package second;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutionImpl implements ExecutionManager {

	private ExecutorService ex;
	
	public ExecutionImpl() {
	 	ex = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	}
	
	public void stopEx(){
		ex.shutdownNow();
	}
	
	@Override
	public Context execute(Runnable callback, Runnable... tasks) {
		int size = tasks.length;
		Future[] futureTasks = new Future[size];
		MyRunnable[] myRuns = new MyRunnable[size];
		Thread threadCall =	new Thread(new Runnable() {			
			@Override
			public void run() {
				callback.run();
			}
		}); 
		for(int i = 0; i < size; i++){
			myRuns[i] =  (MyRunnable) tasks[i];
			futureTasks[i] = ex.submit(myRuns[i]);
		}
		Context result = new ContextImpl(futureTasks, myRuns);
		threadCall.start();
		return result;
	}

}
