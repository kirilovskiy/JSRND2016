package home.seventeenth.decorator;

public class ConfigWithClimate extends ConfigDecorator {

    float addedPrice;

    public ConfigWithClimate(Configuration config) {
        super(config);
        addedPrice = 550;
    }

    @Override
    public float getPrice() {
        return config.getPrice()+addedPrice;
    }

    @Override
    public String printConfiguration() {
        return config.printConfiguration()+"add climate(price:"+addedPrice+");";
    }
}
