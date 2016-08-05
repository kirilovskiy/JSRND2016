package home.sixth;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class sixth {

    static void methods(){
        Class a = String.class;
        int cnt = 0 ;
        //System.out.println("getters are :");
        for (Method method: a.getDeclaredMethods()){
            if (!method.getReturnType().getCanonicalName().equals("void")) {
                cnt++;
                System.out.println(method.getReturnType().getCanonicalName() + " " + method.getName());
            }
        }
        System.out.println(cnt);
    }

    class Constants{
        public static final String MONDAY = "MONDAY";
        public static final String TUESDAY = "TUESDAY";
        public static final String WEDNESDAY = "wednesday";
        public static final String THURSDAY = "THURSDAY";
        public static final String FRIDAY = "FRIDAY";
        public int nums = 1;
        public double f = 2.3;
        public String string = "string";
    }

    static void strConstants(){
        Class consts = Constants.class;
        for (Field f : consts.getDeclaredFields()){
            try{
                if (Modifier.isStatic(f.getModifiers()) &&
                    Modifier.isFinal(f.getModifiers()) &&
                    (f.getName().equals((String)f.get(consts))) ) {
                        System.out.println("Name : "+f.getName()+" ; Value : "+ (String) f.get(consts)+";");
                }
            } catch (IllegalAccessException e) {
                    e.printStackTrace();
            }
        }
    }

    public static interface Calculator {
        public int sum(int a, int b);
    }

    public static class SlowCalculator implements Calculator{
        @Override
        public int sum(int a, int b) {
            return a + b;
        }
    }

    public static void main(String[] args) {
        System.out.println("Вывести все геттеры класса");
        methods();
        System.out.println("Проверить что все String константы имеют значение = их имени");
        strConstants();
        System.out.println("Реализовать кэширующий прокси");

        Calculator c = new SlowCalculator();
        c = CachedProxy.create(Calculator.class, c);

        System.out.println(c.sum(1,2));
        System.out.println(c.sum(2,3));
        System.out.println(c.sum(1,2));
    }
}
