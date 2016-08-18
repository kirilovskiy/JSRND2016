import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;


public class ThreadPool {

    public static int readPoolFile(String path) throws IOException {
        if (!(new File(path)).exists()) {
            System.err.println("File with words isn't exist");
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
        int startIndex;
        int endIndex;
        int sumChars = 0;

        public MyThread(List<String> list, int startIndex, int endIndex) {
            this.list = list;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        public void run() {
            for (int i = startIndex; i < endIndex; i++) {
                sumChars += list.get(i).length();
            }
            System.out.println("Часть с " + startIndex + " по " + endIndex + " мы посчитали с помощью потока " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        List<String> ListWords = new ArrayList<>();
        int sumChars = 0;
        int poolSize = 1;
        int cntProc = Runtime.getRuntime().availableProcessors();
        try{
            poolSize = readPoolFile("C:/1/pool.txt");
            poolSize = cntProc > poolSize ? cntProc : poolSize;
            readWordsFile(ListWords, "C:/1/1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        int step = ListWords.size() / poolSize;
        // упрощенная реализация пула с потоками
        ArrayList<MyThread> listThreads = new ArrayList<>();
        long s1 = System.currentTimeMillis();
        for(int i = 0; i < ListWords.size();){
            int end = (i+step<ListWords.size() ? i+step : ListWords.size());
            MyThread myThread = new MyThread(ListWords, i, end);
            listThreads.add(myThread);
            myThread.start();
            i += step;
        }

        for(int i = 0; i < listThreads.size(); ++i ){
            try {
                listThreads.get(i).join();
                sumChars += listThreads.get(i).sumChars;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long f1 = System.currentTimeMillis();
        System.out.println("Time with own threadpool in milliseconds = "+ (f1-s1) + " count of chars = " + sumChars);

        // встроенными средствами без разбиения на потоки
        int sumChars3 = 0;
        long s3 = System.currentTimeMillis();
        /*for(int i = 0; i < ListWords.size(); i++){
            sumChars3 += ListWords.get(i).length();
        }*/
        sumChars3 = ListWords.stream().collect(Collectors.summingInt(i -> i.length()));
        long f3 = System.currentTimeMillis();
        System.out.println("Time with stream() in milliseconds = " + (f3 - s3) + " count of chars = " + sumChars3);

        // встроенными средствами без разбиения на потоки
        int sumChars4 = 0;
        long s4 = System.currentTimeMillis();
        sumChars4 = ListWords.parallelStream().collect(Collectors.summingInt(i -> i.length()));
        long f4 = System.currentTimeMillis();
        System.out.println("Time with parallelStream() in milliseconds = " + (f4 - s4) + " count of chars = " + sumChars4);
    }
}