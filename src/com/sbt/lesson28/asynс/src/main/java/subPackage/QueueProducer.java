package subPackage;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.jms.*;

public class QueueProducer {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(QueueExampleConfig.class, args);
        ConnectionFactory connectionFactory = context.getBean(ConnectionFactory.class);
        Queue queue =  context.getBean(Queue.class);

        try (Connection connection = connectionFactory.createConnection()) {
            Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(queue);
            Message message = session.createTextMessage("My test message " + System.currentTimeMillis());

            producer.send(message);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
