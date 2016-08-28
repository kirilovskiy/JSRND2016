package second;

import java.util.concurrent.Future;

public class ContextImpl implements Context {
	public Future[] futureTasks;
	public MyRunnable[] myRuns;
	
	public ContextImpl(Future[] futureTasks, MyRunnable[] myRuns) {
		this.futureTasks = futureTasks;
		this.myRuns = myRuns;
	}

	@Override
	public int getCompletedTaskCount() {
		int cnt = 0;
		for(int i = 0; i < futureTasks.length; i++){
			if (!futureTasks[i].isDone() || myRuns[i].isEnd()){ continue; }
			try{
				futureTasks[i].get();
				cnt++;
			} catch (Exception e){
				System.out.println("Exception in counting completed task");
			}
				
		}
		return cnt;
	}

	@Override
	public int getFailedTaskCount() {
		int cnt = 0;
		for(Future f : futureTasks){
			if (!f.isDone()){ continue; }
			try{
				f.get();
			} catch (Exception e){
				cnt++;
			}
				
		}
		return cnt;
	}

	@Override
	public int getInterruptedTaskCount() {
		int cnt = 0;
		for(MyRunnable r : myRuns){
			if (r.isEnd()) 
				cnt++;
		}
		return cnt;
	}

	@Override
	public void interrupt() {
		for(MyRunnable r : myRuns){
			r.endRun();
		}
	}

	@Override
	public boolean isFinished() {
		for(Future f : futureTasks){
			if (!f.isDone()) return false;
		}
		return true;
	}

}
