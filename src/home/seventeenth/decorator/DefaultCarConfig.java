package home.seventeenth.decorator;

public class DefaultCarConfig implements Configuration{
    @Override
    public float getPrice() {
        return 10000;
    }

    @Override
    public String printConfiguration() {
        return "base car ";
    }
}
