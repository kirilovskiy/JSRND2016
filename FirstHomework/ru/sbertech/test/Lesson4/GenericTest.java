package ru.sbertech.test.Lesson4;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) {
        /*A <List> a = new A<>();
        a.setParam(new <String>ArrayList());
        A <Integer> aString = new A<>();
        aString.setParam(134);
        System.out.println(a.getType());
        System.out.println(aString.getType());

        System.out.println(new A<String>(new String()){
          @Override
            public String getType(){
               return "Abstract "+ param.getClass().getTypeName();
          }
        }.getType());
        //необязательная параметризация
        //System.out.println(B.getType(new Short("10")));

        System.out.println(B.<Short>getType(new Short("10")));

        List<?> i = new ArrayList<Integer>();
        i.add(null);*/
        A<? extends B> a = new A<>(new B());
        A aa = a.getParam();
        B b = a.getParam();

        List<? super Number> list = new ArrayList<>();
        list.add(new Integer(10));
        list.add(new Double(11));
        list.add(new Integer(12));
        list.add(new Double(13));
        list.forEach(System.out::println); // только для java 1.8 и выше
        // Integer i = list.get(0); //error
        // Object obj = list.get(0); //norm
    }
}
