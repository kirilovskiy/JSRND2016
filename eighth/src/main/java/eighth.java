import java.util.Iterator;
import org.joda.time.LocalTime;

public class eighth {
    public static void main(String[] args) {
        LocalTime currentTime = new LocalTime();
        System.out.println("The current local time is: " + currentTime);

        MyList<String> list = new MyList<String>();
        list.add("2");
        list.add("3");
        list.add("1");
        list.add("5");
        list.remove(6);
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
