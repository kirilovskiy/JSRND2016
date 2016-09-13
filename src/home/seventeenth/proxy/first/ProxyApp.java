package home.seventeenth.proxy.first;

import java.util.ArrayList;

public class ProxyApp {
    public static void main(String[] args) {
        ArrayList<IProduct> products =  new ArrayList<>();
        products.add( new ProxyProduct(new Product(1000,"Bike",false)));
        products.add( new ProxyProduct(new Product(3000,"Motorcycle",true)));
        products.stream().forEach(System.out::println);
    }
}
