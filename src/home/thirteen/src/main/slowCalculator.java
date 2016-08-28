package home.thirteen.src.main;

public class slowCalculator implements iCalculator{
    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public int subtraction(int a, int b) {
        return a - b;
    }
}
