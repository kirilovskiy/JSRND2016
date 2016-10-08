package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class utilContext {
    public static final ApplicationContext context = new ClassPathXmlApplicationContext("/resources/context.xml");
}
