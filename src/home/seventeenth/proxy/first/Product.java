package home.seventeenth.proxy.first;

public class Product implements IProduct{
    private int price;
    private String nameProduct;
    private boolean bringing;

    public Product(int price, String nameProduct, boolean bringing) {
        this.price = price;
        this.nameProduct = nameProduct;
        this.bringing = bringing;
    }

    @Override
    public boolean isNeedToBring() {
        return bringing;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getNameProduct() {
        return nameProduct;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setBringing(boolean bringing) {
        this.bringing = bringing;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                "$, nameProduct='" + nameProduct + '\'' +
                '}';
    }
}
