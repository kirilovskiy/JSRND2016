package first;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

public class Pool {
    public static int readPoolFile(String path) throws IOException {
        if (!(new File(path)).exists()) {
            System.err.println("File pool isn't exist");
            System.exit(1);
        }
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(path)))
        {
            while ((line = reader.readLine()) != null) {
                return Integer.parseInt(line);
            }
        }
        return 1;
    }

    public static void readWordsFile(Collection ts, String path) throws IOException {
        if (!(new File(path)).exists()) {
            System.err.println("File with words size isn't exist");
            System.exit(1);
        }

        String line;
        try(BufferedReader reader = new BufferedReader(new FileReader(path)))
        {
            while ((line = reader.readLine()) != null) {
                ts.addAll(Arrays.asList(line.split("[\\s\\p{Punct}]+")));
            }
        }
    }

    public static void main(String[] args) {
        List<String> ListWords = new ArrayList<>();
        int sumChars = 0;
        int poolSize = 1;
        int cntProc = Runtime.getRuntime().availableProcessors();
        try{
            poolSize = readPoolFile("data\\pool.txt");
            poolSize = cntProc > poolSize ? cntProc : poolSize;
            readWordsFile(ListWords, "data\\1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        int step = ListWords.size() / poolSize;
        // создаем фиксированный пул потоков
        ExecutorService ex = Executors.newFixedThreadPool(poolSize);

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
            //while (!future.isDone()) {/*ждем пока задача не выполнится*/}
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
}
