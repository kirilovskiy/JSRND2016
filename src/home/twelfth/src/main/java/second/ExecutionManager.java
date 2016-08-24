package second;

public interface ExecutionManager {
    Context execute(Runnable callback, Runnable... tasks);
}
