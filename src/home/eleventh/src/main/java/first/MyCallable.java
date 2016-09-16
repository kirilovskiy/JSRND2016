package home.eleventh.src.main.java.first;

import java.util.List;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    MySubList mySubList;

    public MyCallable(List<String> list) {
        this.mySubList = new MySubList(list);
    }
    //отделим реализацию подсчета в другой класс, чтоб не были перемешаны реализация и callable
    @Override
    public Integer call() throws Exception {
        int cL = mySubList.countLetters();
        System.out.println("Поток "+ Thread.currentThread().getName() + " насчитал " + cL);
        return cL;
    }
}