package second;

public class ContextImpl implements Context {
    private int CompletedTaskCount;
    private int FailedTaskCount;
    private int InterruptedTaskCount;
    private boolean isFinish;

    public ContextImpl(int completedTaskCount, int failedTaskCount, int interruptedTaskCount, boolean isFinish) {
        CompletedTaskCount = completedTaskCount;
        FailedTaskCount = failedTaskCount;
        InterruptedTaskCount = interruptedTaskCount;
        this.isFinish = isFinish;
    }

    @Override
    public int getCompletedTaskCount() {
        return CompletedTaskCount;
    }

    @Override
    public int getFailedTaskCount() {
        return FailedTaskCount;
    }

    @Override
    public int getInterruptedTaskCount() {
        return InterruptedTaskCount;
    }

    @Override
    public void interrupt() { Thread.interrupted(); }

    @Override
    public boolean isFinished() {
        return isFinish;
    }
}
