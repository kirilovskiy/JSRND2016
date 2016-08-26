package home.twelfth.src.main.java.second;

public class MyRunnable implements Runnable {
	private Runnable innerRun;
	private volatile boolean endFlag = false;
	
	public MyRunnable(Runnable innerRun) {
		this.innerRun = innerRun;		
	}
	
	@Override
	public void run() {
		if (!endFlag){
			innerRun.run();
		}
	}
	
	public void endRun(){
		endFlag = true; 
	}
	
	public boolean isEnd(){
		return endFlag;
	}

}
