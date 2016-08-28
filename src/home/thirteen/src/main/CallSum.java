package home.thirteen.src.main;

import java.util.concurrent.Callable;

public class CallSum implements Callable {
    private int s1;
    private int s2;
    iCalculator calculator;

    public CallSum(iCalculator calculator, int s1, int s2) {
        this.calculator = calculator;
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public Object call() throws Exception {
        return calculator.sum(s1,s2);
    }
}
