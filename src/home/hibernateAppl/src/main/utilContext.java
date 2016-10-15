
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class utilContext {
    private static final ApplicationContext applicationContext;

    static {
        applicationContext = new ClassPathXmlApplicationContext("resources/context.xml");
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }
}
