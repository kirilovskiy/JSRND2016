package third;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MesSystem {
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

    public static class MyRunnable implements Runnable{
        private String mes;

        public MyRunnable(String mes) {
            this.mes = mes;
        }
        @Override
        public void run() {
            System.out.println("Выполнял поток " + Thread.currentThread().getName()+"; Сообщение - '" + mes +"\'");
        }
    }

    public static void main(String[] args) {
        int poolSize = 1;
        try{
            poolSize = readPoolFile("data\\pool.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        WorkQueue workQueue = new WorkQueue(poolSize);
        for(int i = 0; i < 100; i++){
            MyRunnable myRunnable = new MyRunnable("Номер задачи " + i);
            workQueue.execute(myRunnable);
        }
    }
}