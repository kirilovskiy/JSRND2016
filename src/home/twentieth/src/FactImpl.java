package home.twentieth.src;

public class FactImpl implements Cachable {

    @Override
    public Long factorial(Integer n) {
        long res=1;
        for (int i = 1; i <= n.intValue(); i++) {
            res = res * i;
        }
        return res;
    }
}
