package home.twelfth.src.main.java.second;

public class Main {

    public static void main(String[] args) {
    	System.out.println("start main");
    	ExecutionImpl execImpl = new ExecutionImpl();
        final int cntTask = 10;
        MyRunnable[] tasks = new MyRunnable[cntTask];
        for(int i = 0; i < cntTask; i++){
        	final int fI = i;
        	Runnable r = new Runnable() {
				@Override
				public void run() {
					System.out.println("Task with number '"+ fI + "\'");
				}
			};
			tasks[i] = new MyRunnable(r);
			// отключим несколько задач
			if (i % 2 == 0) tasks[i].endRun();
        }
        
        Runnable callback = new Runnable() {			
			@Override
			public void run() {
				System.out.println("Callback execute!");
			}
		};

		
		Context impl = execImpl.execute(callback, tasks);
		
		while (!impl.isFinished()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
		
        System.out.println("----------------------------------------------------");
        System.out.println("CompletedTaskCount = " + impl.getCompletedTaskCount() + ";\n" +
        					"FailedTaskCount = " + impl.getFailedTaskCount()+ ";\n" +
        					"InterruptedTaskCount = " + impl.getInterruptedTaskCount()+ ";\n" +
        					"isFinished = " + impl.isFinished());
        
        execImpl.stopEx();
        System.out.println("End main");
    }
}
