package home.thirteen.src.main;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        iCalculator calc = CachedProxy.doCached(new slowCalculator());
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        int cntTasks = 100;
        Integer[] results = new Integer[cntTasks];
        Future<Integer>[] future = new Future[cntTasks];
        // кэшированная однопоточное
        for(int i = 0; i < cntTasks; i++){
            int s1 = new Random().nextInt(10);
            int s2 = new Random().nextInt(10);
            results[i] = calc.sum(s1,s2);
        }
        Thread.sleep(1000);
        // кэшированная,многопоточная с threadpool
        for(int i = 0; i < cntTasks; i++){
            int s1 = new Random().nextInt(10);
            int s2 = new Random().nextInt(10);
            future[i] = executorService.submit(new CallSum(calc,s1,s2));
        }
        Thread.sleep(1000);
        System.out.println("-------------------");
        /*for(int i = 0; i < cntTasks; i++){
            System.out.println(future[i].get());
        }
        System.out.println("-------------------");*/
        executorService.shutdown();
        System.out.println("end of main");
    }
}
