package second;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
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

    public static class MyThread extends Thread {
        List<String> list;
        int sumChars = 0;

        public MyThread(List<String> list) {
            this.list = list;
        }

        @Override
        public void run() {
            sumChars += list.stream()
                    .collect(Collectors
                            .summingInt(i ->
                            {
                                int sum = 0;
                                for (int j = 0; j < i.length(); j++) {
                                    sum += Character.isLetter(i.charAt(j)) ? 1 : 0;
                                }
                                return sum;
                            }));
            System.out.println("работал поток " + Thread.currentThread().getName() + " kol = "+sumChars);
        }
    }

    public static class MyRunnable implements Runnable{
        List<String> list;
        int sumChars = 0;

        public MyRunnable(List<String> list) {
            this.list = list;
        }

        @Override
        public void run() {
            sumChars += list.stream()
                    .collect(Collectors
                            .summingInt(i ->
                            {
                                int sum = 0;
                                for (int j = 0; j < i.length(); j++) {
                                    sum += Character.isLetter(i.charAt(j)) ? 1 : 0;
                                }
                                return sum;
                            }));
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
        WorkQueue workQueue = new WorkQueue(poolSize);
        for(int i = 0; i < ListWords.size();){
            int end = (i+step<ListWords.size() ? i+step : ListWords.size());
            MyRunnable myRunnable = new MyRunnable(ListWords.subList(i, end));
            workQueue.execute(myRunnable);
            i += step;
        }

        workQueue.await();
        sumChars = workQueue.cntChars;
        System.out.println("всего букв " + sumChars);
    }
}
