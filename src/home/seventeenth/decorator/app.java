package home.seventeenth.decorator;

public class app {
    public static void main(String[] args) {
        Configuration configuration = new DefaultCarConfig();
        System.out.println(configuration.printConfiguration() + " price = " + configuration.getPrice());

        Configuration climateConf = new ConfigWithClimate(configuration);
        System.out.println(climateConf.printConfiguration() + " price = " + climateConf.getPrice());

        Configuration musicConf = new ConfigWithMusic(configuration);
        System.out.println(musicConf.printConfiguration() + " price = " + musicConf.getPrice());

        Configuration fullComplect = new ConfigWithAllRoad(new ConfigWithLeatherUpholstery(configuration));
        System.out.println(musicConf.printConfiguration() + " price = " + fullComplect.getPrice());
    }
}
