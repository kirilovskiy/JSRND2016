package com.sbt.lesson15;

import java.io.IOException;
import java.net.*;

public class ServerUDP {
    public static final String HOST = "localhost";
    public static final int PORT = 3333;
    public static final int BUFFER_SIZE = 256;
    public static final String MULTICAST_GROUP = "224.0.0.22";

    public static void main(String[] args) throws IOException {
        try (/*DatagramSocket socket = new DatagramSocket(PORT) */
             MulticastSocket socket = new MulticastSocket(PORT))
        {
             InetAddress multicastAddress = InetAddress.getByName(MULTICAST_GROUP);
             socket.joinGroup(multicastAddress);
             byte[] buffer = new byte[BUFFER_SIZE];
             String command = "";
             do{
                 DatagramPacket datagram = new DatagramPacket(buffer, buffer.length);
                 socket.receive(datagram);
                 command = new String(datagram.getData(), 0 , datagram.getLength());
                 System.out.println(command);
             } while (!command.equals("exit"));
        }
    }
}
