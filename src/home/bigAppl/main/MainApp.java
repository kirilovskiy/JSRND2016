package main;

import main.logic.Client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context;
        context = new ClassPathXmlApplicationContext("/resource/context.xml");
        Client client = (Client) context.getBean("client");
        client.setId(1);
        client.setName("Sergey");
        System.out.println(client.toString());
    }
}
