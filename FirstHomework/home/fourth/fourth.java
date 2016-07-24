package home.fourth;

import java.util.Iterator;
import java.util.ListIterator;

public class fourth {
    public static void main(String[] args) {
        myLinkedList<String> list = new myLinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add(2, "1");
        for(int i = 0; i < list.size ; i++){
            System.out.println(list.get(i));
        }
        list.remove(1);
        ListIterator<String> it =  list.listIterator(0);
        while(it.hasNext()){
            System.out.println(it.next());
        }
        /*ListIterator<String> it1 =  list.listIterator(list.size-1);
        while(it1.hasPrevious()){
            System.out.println(it1.previous());
        }*/
    }
}
