package home.seventeenth.decorator;

public class ConfigWithAllRoad extends ConfigDecorator {

    float addedPrice;

    public ConfigWithAllRoad(Configuration config) {
        super(config);
        addedPrice = 4000;
    }

    @Override
    public float getPrice() {
        return config.getPrice()+addedPrice;
    }

    @Override
    public String printConfiguration() {
        return config.printConfiguration()+"add all-road equipment(price:"+addedPrice+");";
    }
}

