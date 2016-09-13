package home.seventeenth.decorator;

public class ConfigWithMusic extends ConfigDecorator {

    float addedPrice;

    public ConfigWithMusic(Configuration config) {
        super(config);
        addedPrice = 300;
    }

    @Override
    public float getPrice() {
        return config.getPrice()+addedPrice;
    }

    @Override
    public String printConfiguration() {
        return config.printConfiguration()+"add music(price:"+addedPrice+");";
    }
}
