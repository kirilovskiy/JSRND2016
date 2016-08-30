package com.sbt.lesson15;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static final int DEFAULT_PORT = 3333;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(DEFAULT_PORT);
        Socket accept = serverSocket.accept(); // поймали соединение
        InputStream inputStream = accept.getInputStream();
        OutputStream outputStream = accept.getOutputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("OK");
        bufferedWriter.write("\n");
        bufferedWriter.flush();

        bufferedReader.close();
        bufferedWriter.close();
        outputStream.close();
        inputStream.close();
        serverSocket.close();
    }
}
