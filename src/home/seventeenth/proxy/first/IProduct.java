package home.seventeenth.proxy.first;

public interface IProduct {
    public static final int DELIVERY_PRICE = 300;

    public boolean isNeedToBring();
    public int getPrice();
    public String getNameProduct();
}
