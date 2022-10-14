package academy.pocu.comp2500.assignment2;

public class Product {
    protected String name;
    protected Size size;
    protected Color color;
    protected int price;
    protected ShippingMethod shippingMethod;

    protected Product(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    protected void addPrice(int price) {
        this.price += price;
    }
}
