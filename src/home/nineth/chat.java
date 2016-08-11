package home.nineth;

import java.io.*;

interface MessageService {
    void send(Message message);

    Message receive();
}

class Message implements Serializable {
    long id;
    String user;
    String message;

    Message(String user, String message) {
        this.id = System.currentTimeMillis();
        this.user = user;
        this.message = message;
    }

    String getKey() {
        return "" + System.identityHashCode(Thread.currentThread()) + user + id;
    }
}

class MessageServiceThroughFileSerialization implements MessageService {

    private File messageFile;

    public MessageServiceThroughFileSerialization(String messageFile) {
        this.messageFile = new File(messageFile);
    }

    @Override
    public void send(Message message) {
        try {
            SerializableUtils.serialize(messageFile.getAbsolutePath(), message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Message receive() {
        while (true) {
            if (messageFile.exists() && messageFile.lastModified() < System.currentTimeMillis() - 500L) {
                try {
                    Message message = (Message) SerializableUtils.deserialize(messageFile.getAbsolutePath());
                    //messageFile.delete();
                    return message;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } //return null;
        }
    }
}

class Client {
    MessageService messageService;
    String lastReceivedMessageKey;
    Client(MessageService messageService) {
        this.messageService = messageService;
    }

    void send() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your username: ");
        String username = reader.readLine();
        System.out.print("Enter message:");
        String line = reader.readLine();
        while (!line.equals("exit")) {
            Message message = new Message(username, line);
            messageService.send(message);
            System.out.print("Enter message:");
            line = reader.readLine();
        }
        System.out.println("End client!");
    }

    void receive() {
        //while(true) {
            System.out.println("Waiting for message...");
            Message receivedMessage = messageService.receive();
            if (receivedMessage !=null && !receivedMessage.getKey().equals(lastReceivedMessageKey)) {
                lastReceivedMessageKey = receivedMessage.getKey();
                System.out.println("new message: " + receivedMessage.id);
                System.out.println("       from: " + receivedMessage.user);
                System.out.println("       body: " + receivedMessage.message);
            }else return;
        //}
    }
}

public class chat {
}
