package home.fourteenth.src.main.java.chat;

import java.io.*;
import java.net.Socket;

public class Worker implements Runnable {
    private Socket socket;
    private String nameUser;

    public Worker(Socket socket, String nameUser) {
        this.socket = socket;
        this.nameUser = nameUser;
    }

    @Override
    public void run() {
        InputStream inputStream = null;

        try {
            inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write("Успешно добавились к чату");
            bufferedWriter.write("\n");
            bufferedWriter.flush();
            System.out.println(nameUser + " онлайн");
            String answer;
            do {
                answer = bufferedReader.readLine();
                if ( answer != null){
                    if (!answer.equals("выход")){
                        System.out.println(nameUser + ":'" + answer + "\'" );
                    } else{
                        bufferedWriter.write("Успешно вышли из чата");
                        bufferedWriter.write("\n");
                        bufferedWriter.flush();
                        Server.delFromMap(socket);
                        System.out.println(nameUser  + " оффлайн");
                    }
                }
            } while(!answer.equals("выход"));

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

