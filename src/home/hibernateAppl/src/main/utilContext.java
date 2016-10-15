package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class utilContext {
    private static final ApplicationContext applicationContext;

    static {
        applicationContext = new FileSystemXmlApplicationContext("/src/home/hibernateAppl/src/resources/context.xml");
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }
}
