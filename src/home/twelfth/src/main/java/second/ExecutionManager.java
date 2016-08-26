package home.twelfth.src.main.java.second;
public interface ExecutionManager {
    Context execute(Runnable callback, Runnable... tasks);
}