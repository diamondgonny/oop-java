package academy.pocu.comp2500.assignment2;

public class Product {
    private String name;
    private Size size;
    private Color color;
    private int price;
    private ShippingMethod shippingMethod;

    protected Product(String name, Size size, Color color, ShippingMethod shippingMethod) {
        this.name = name;
        this.size = size;
        this.color = color;
        this.shippingMethod = shippingMethod;
    }

    protected Product(String name, Size size, Color color, int price, ShippingMethod shippingMethod) {
        this(name, size, color, shippingMethod);
        this.price = price;
    }

    // getter, setter

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

    protected void setSize(Size size) {
        this.size = size;
    }

    protected void setColor(Color color) {
        this.color = color;
    }

    protected void setPrice(int price) {
        this.price = price;
    }

    protected void addPrice(int price) {
        this.price += price;
    }
}
