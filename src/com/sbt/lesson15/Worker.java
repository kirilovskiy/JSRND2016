package com.sbt.lesson15;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Random;

public class Worker implements Runnable {
    private Socket socket;
    public Worker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        int secretNumber = new Random().nextInt(9);
        System.out.println("Загадали " + secretNumber);
        try {
            inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write("Попробуй угадай");
            bufferedWriter.write("\n");
            bufferedWriter.flush();

            String answer;
            while (true){
                if ((answer = bufferedReader.readLine()) != null){
                    if (secretNumber == Integer.valueOf(answer)){
                        bufferedWriter.write("Вы угадали число");
                        break;
                    } else {
                        bufferedWriter.write("Не угадали");
                        bufferedWriter.write("\n");
                        bufferedWriter.flush();
                    }
                }
            }

            bufferedReader.close();
            bufferedWriter.close();
            outputStream.close();
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
