package home.fourteenth.src.main.java.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    public static final String HOST = "localhost";
    public static final int PORT = 8283;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(HOST,PORT);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String a = bufferedReader.readLine();
        if (a.equals("Отказ")) {
            System.out.println(bufferedReader.readLine());
            bufferedReader.close();
            bufferedWriter.close();
            outputStream.close();
            inputStream.close();
            socket.close();
            System.exit(1);
        }

        System.out.println(a);
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        String answer;
        do {
            if ((answer = consoleReader.readLine()) != null){
                bufferedWriter.write(answer);
                bufferedWriter.write("\n");
                bufferedWriter.flush();
            }
        } while(!answer.equals("выход"));

        bufferedReader.close();
        bufferedWriter.close();
        outputStream.close();
        inputStream.close();
        socket.close();
    }
}