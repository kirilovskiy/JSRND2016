package home.fourteenth.src.main.java.chat_semaphore;

import java.io.*;
import java.net.Socket;

public class Client {
    public static final String HOST = "localhost";
    public static final int PORT = 8283;
    private BufferedReader reader;
    private BufferedWriter writer;
    private Socket socket;

    public Client() {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        try{
            socket = new Socket(HOST , PORT);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            System.out.println("Please, enter your name:");
            writer.write(console.readLine()+"\n");
            writer.flush();

            if (!reader.readLine().equals("fail")) {
                Resender resender = new Resender();
                resender.start();
                System.out.println("you on-line!");
                String sendStr = "";
                while(!sendStr.equals("exit") && sendStr!=null){
                    try {
                        sendStr = console.readLine();
                        writer.write(sendStr + "\n");
                        writer.flush();
                    } catch (Exception e){
                        break;
                    }
                }
                resender.setStop();
            } else {
                System.out.println("Sorry, but there aren't places in chat.");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            close();
        }
    }

    private void close(){
        try{
            reader.close();
            writer.close();
            socket.close();
        }catch(Exception e) {
            System.err.println("Thread didn't close!");
        }
    }

    private class Resender extends Thread {
        private boolean stoped = false;

        public void setStop(){
            stoped = true;
        }

        @Override
        public void run(){
            try{
                while(!stoped){
                    String str = reader.readLine();
                    System.out.println(str);
                }
            } catch (IOException e){
                System.err.println("Error when receiving message");
            }
        }
    }

    public static void main(String[] args){
        new Client();
    }
}
