package subPackage;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.jms.*;
//http://127.0.0.1:8161/admin/
public class QueueConsumer {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(QueueExampleConfig.class, args);
        ConnectionFactory connectionFactory = context.getBean(ConnectionFactory.class);
        Queue queue =  context.getBean(Queue.class);

        try (Connection connection = connectionFactory.createConnection()) {

            connection.start();

            Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
            MessageConsumer consumer = session.createConsumer(queue);
            TextMessage message = (TextMessage) consumer.receive();

            System.out.println("text from producer " + message.getText());
            message.acknowledge();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
