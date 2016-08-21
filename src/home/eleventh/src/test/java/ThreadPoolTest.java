import first.MyCallable;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static first.Pool.readPoolFile;
import static first.Pool.readWordsFile;

public class ThreadPoolTest {
    private List<String> ListWords;
    private int sumChars = 0;
    private int poolSize;
    private int cntProc;
    private int step;
    private ExecutorService ex;
    List<Future<Integer>> list;

    @Before
    public void init() throws IOException {
        ListWords = new ArrayList<>();
        cntProc = Runtime.getRuntime().availableProcessors();
        poolSize = readPoolFile("C:\\Users\\Анеля\\IdeaProjects\\JSRND2016\\data\\pool.txt");
        poolSize = cntProc > poolSize ? cntProc : poolSize;
        readWordsFile(ListWords, "C:\\Users\\Анеля\\IdeaProjects\\JSRND2016\\data\\1.txt");
        step = ListWords.size() / poolSize;
        ex = Executors.newFixedThreadPool(poolSize);
    }

    @Test
    public void poolSize() {
        Assert.assertTrue("poolsize = "+ poolSize, poolSize==10);
    }

    @Test
    public void setEx(){
        List<Future<Integer>> list = new ArrayList<>();
        long s2 = System.currentTimeMillis();
        if (ListWords.size() > poolSize) {
            for (int i = 0; i < ListWords.size(); ) {
                int end = (i + step < ListWords.size() ? i + step : ListWords.size());
                list.add(ex.submit(new MyCallable(ListWords.subList(i, end))));
                i += step;
            }
        } else
        {
            list.add(ex.submit(new MyCallable(ListWords)));
        }

        for (Future<Integer> future : list) {
            try {
                sumChars += future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        ex.shutdown();
        long f2 = System.currentTimeMillis();
        System.out.println("Time with ExecutorService in milliseconds= "+ (f2-s2) + " count of chars = " + sumChars);
    }

    @After
    public void clear(){
        ListWords=null;
    }
}
