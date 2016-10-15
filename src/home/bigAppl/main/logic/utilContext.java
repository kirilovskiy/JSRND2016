package logic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class utilContext {
    public static final ApplicationContext context =
                new FileSystemXmlApplicationContext("/src/home/bigAppl/resources/context.xml");
}
