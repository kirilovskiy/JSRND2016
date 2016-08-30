package com.sbt.lesson15;

import java.io.*;
import java.net.Socket;

public class MyClient {
    public static final String HOST = "localhost";
    public static final int PORT = 3333;
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(HOST,PORT);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

//        bufferedWriter.write("Hello");
//        bufferedWriter.write("\n");
//        bufferedWriter.flush();
        System.out.println(bufferedReader.readLine());
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        String answer;
        while (true) {
            if ((answer = consoleReader.readLine()) != null) {
                bufferedWriter.write(answer);
                bufferedWriter.write("\n");
                bufferedWriter.flush();

                String fromServer = bufferedReader.readLine();
                System.out.println(fromServer);
                if (fromServer.equals("Угадал")) {
                    break;
                }else {

                }
            }
        }

        bufferedReader.close();
        bufferedWriter.close();
        outputStream.close();
        inputStream.close();
        socket.close();
    }
}
