package home.seventeenth.proxy.first;

/**
 * Created by 1 on 11.09.2016.
 */
public class ProxyProduct implements IProduct{
    private Product product;

    public ProxyProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean isNeedToBring() {
        return product.isNeedToBring();
    }

    @Override
    public int getPrice() {
        if (!isNeedToBring()){
            return product.getPrice() + DELIVERY_PRICE;
        }
        return product.getPrice();
    }

    @Override
    public String getNameProduct() {
        if (!isNeedToBring()){
            return "[IS NEED TO BRING TO OUR WAREHOUSE!] " + product.getNameProduct();
        }else return "[Take away] " + product.getNameProduct();
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + getPrice() +
                "$, nameProduct='" + getNameProduct() + '\'' +
                '}';
    }
}
