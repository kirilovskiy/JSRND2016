package home.seventeenth.decorator;

public abstract class ConfigDecorator implements Configuration {
    protected Configuration config;

    public ConfigDecorator(Configuration config) {
        this.config = config;
    }

    @Override
    public float getPrice() {
        return config.getPrice();
    }

    @Override
    public String printConfiguration() {
        return config.printConfiguration();
    }
}
