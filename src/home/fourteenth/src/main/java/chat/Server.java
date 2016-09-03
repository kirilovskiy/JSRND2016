package home.fourteenth.src.main.java.chat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static final String HOST = "localhost";
    public static final int PORT = 8283;
    public static final int MAX_CLIENTS = 2;
    private static int cnt = 1;
    private static Map<Socket, String> clients = new HashMap<Socket, String>();

    public static void delFromMap(Socket socket) throws IOException {
        clients.remove(socket);
        --cnt;
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        System.out.println("Сервер начал слушать");
        System.out.println("Чат начался(сервер)");
        while(true) {
            Socket accept = serverSocket.accept(); // поймали соединение
            if (cnt <= MAX_CLIENTS){
                clients.put(accept, "пользователь " + accept.toString());
                ++cnt;
                executorService.execute(new Worker(accept, clients.get(accept).toString()));
            }else {
        	   	/*clients.remove(accept);
            	--cnt;*/
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
                bufferedWriter.write("Отказ");
                bufferedWriter.write("\n");
                bufferedWriter.write("Отказано в добавление к чату. Чат заполнен под завязку.");
                bufferedWriter.write("\n");
                bufferedWriter.flush();
                bufferedWriter.close();
                accept.close();
            }
        }
    }
}

