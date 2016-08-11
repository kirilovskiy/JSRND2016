package home.nineth;

import java.io.IOException;

public class ex {
    public static void main(String[] args) {
        MessageService messageService = new MessageServiceThroughFileSerialization("chat-message.ser");
        Client c1 = new Client(messageService);
        Client c2 = new Client(messageService);
        try {
            System.out.println("Первый отправляет");
            c1.send();
            System.out.println("Второй получил");
            c2.receive();
            System.out.println("Второй отправляет");
            c2.send();
            System.out.println("Первый получил");
            c1.receive();
        } catch (IOException e) {
            System.out.println("Произошла ошибка при отправке/приеме сообщений");
        }

    }
}
