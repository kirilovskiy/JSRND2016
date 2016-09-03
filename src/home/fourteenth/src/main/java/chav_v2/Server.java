package home.fourteenth.src.main.java.chav_v2;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Server {
    public static final int PORT = 8283;
    public static final int MAX_CLIENTS = 2;
    private List<Connection> connections = Collections.synchronizedList(new ArrayList<Connection>());
    private ServerSocket serverSocket;

    public Server(){
        try{
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server starts");
            while(true){
                Socket socket = serverSocket.accept();
                BufferedReader readerName = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String name = readerName.readLine();
                if (connections.size()+1 > MAX_CLIENTS) {
                    BufferedWriter writerFail = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    writerFail.write("fail\n");
                    writerFail.flush();
                    writerFail.close();
                }else{
                    Connection con =  new Connection(socket, name);
                    connections.add(con);
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
                for(Connection c : connections){
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

        public Connection(Socket socket, String name){
            this.socket = socket;
            this.name = name;
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

                synchronized (connections) {
                    for(Connection c : connections){
                        /*if (!c.name.equals(this.name))*/ {
                            c.writer.write(name + " join us\n");
                            c.writer.flush();
                        }
                    }
                }

                String str = "";

                while(true){
                    str = reader.readLine();
                    if (str.equals("exit")) break;
                    //send messages for all clients
                    synchronized (connections) {
                        for(Connection c : connections){
                            c.writer.write(name + ": " + str + "\n");
                            c.writer.flush();
                        }
                    }
                }

                synchronized (connections) {
                    for(Connection c : connections){
                        /*if (!c.name.equals(this.name))*/ {
                            c.writer.write(name + " off-line \n");
                            c.writer.flush();
                        }
                    }
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