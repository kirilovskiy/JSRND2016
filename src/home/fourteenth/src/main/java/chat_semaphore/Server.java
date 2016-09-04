package home.fourteenth.src.main.java.chat_semaphore;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

public class Server {
    public static final int PORT = 8283;
    public static final int MAX_CLIENTS = 2;
    private ConcurrentHashMap<Connection, String> connections = new ConcurrentHashMap<>();
    private ServerSocket serverSocket;
    private static final Semaphore semaphore_clients = new Semaphore(MAX_CLIENTS);

    public Server(){
        try{
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server starts");
            while(true){
                Socket socket = serverSocket.accept();
                BufferedReader readerName = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String name = readerName.readLine();
                if (!semaphore_clients.tryAcquire()) {
                    BufferedWriter writerFail = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    writerFail.write("fail\n");
                    writerFail.flush();
                    writerFail.close();
                }else{
                    Connection con =  new Connection(socket, name, semaphore_clients);
                    connections.put(con, name);
                    con.start();
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally{
            closeAll();
        }
    }

    private void closeAll(){
        try {
            serverSocket.close();
            synchronized (connections) {
                for(Connection c : connections.keySet()){
                    c.close();
                }
            }
            System.out.println("Server close");
        } catch (IOException e) {
            System.err.println("Treads didn't close");
        }

    }

    private class Connection extends Thread{
        private Socket socket;
        private String name = "";
        private BufferedReader reader;
        private BufferedWriter writer;
        private Semaphore semaphore;

        public Connection(Socket socket, String name, Semaphore semaphore){
            this.socket = socket;
            this.name = name;
            this.semaphore = semaphore;
            try{
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            }catch(IOException e){
                e.printStackTrace();
                close();
            }
        }

        @Override
        public void run(){
            try{
                for(Connection c : connections.keySet()){
                   c.writer.write(name + " join us\n");
                   c.writer.flush();
                }

                String str = "";

                while(true) {
                    str = reader.readLine();
                    if (str.equals("exit")) break;
                    //send messages for all clients
                    for (Connection c : connections.keySet()) {
                        c.writer.write(name + ": " + str + "\n");
                        c.writer.flush();
                    }
                }

                for(Connection c : connections.keySet()){
                   c.writer.write(name + " off-line \n");
                   c.writer.flush();
                }

            } catch (IOException e){
                e.printStackTrace();
            } finally {
                close();
            }

        }

        private void close(){
            try{
                reader.close();
                writer.close();
                socket.close();
                connections.remove(this);
                semaphore.release();
                if (connections.size() == 0) {
                    Server.this.closeAll();
                    System.exit(0);
                }

            }catch(Exception e) {
                System.err.println("Thread didn't close!");
            }
        }
    }


    public static void main(String[] args){
        new Server();
    }
}