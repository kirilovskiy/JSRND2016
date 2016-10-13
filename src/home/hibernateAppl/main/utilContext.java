package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class utilContext {
    private static final ApplicationContext applicationContext;

    static {
        applicationContext = new ClassPathXmlApplicationContext("/resources/context.xml");
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }
}
