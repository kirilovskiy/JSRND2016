package third;

import java.util.LinkedList;

public class WorkQueue {
    private final int cntThreads;
    private final PoolWorker[] threads;
    private final LinkedList queue;
    private volatile boolean endFlag = false;

    public boolean isEndFlag() {
        return endFlag;
    }

    public WorkQueue(int cntThreads) {
        this.cntThreads = cntThreads;
        queue = new LinkedList();
        threads = new PoolWorker[cntThreads];

        for (int i = 0; i < cntThreads; i++) {
            threads[i] = new PoolWorker();
            threads[i].start();
        }
    }

    public void execute(Runnable r) {
        synchronized (queue) {
            queue.addLast(r);
            queue.notify();
        }
    }

    private class PoolWorker extends Thread {
        public void run() {
            System.out.println("стартанул поток " + Thread.currentThread().getName());
            Runnable r;

            while (!endFlag) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Ошибка " + e.getMessage());
                            interrupt();
                        }
                    }
                    r = (Runnable) queue.removeFirst();
                }

                try {
                    r.run();
                } catch (RuntimeException e){
                    System.out.println("Ошибка " + e.getMessage());
                }
            }
        }
    }

    public boolean EndFlag(){
        while (!queue.isEmpty()){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        synchronized (this) {
            endFlag = true;
            notifyAll();
        }
        return true;
    }

}