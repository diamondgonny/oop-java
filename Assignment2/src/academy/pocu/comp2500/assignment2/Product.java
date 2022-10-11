package academy.pocu.comp2500.assignment2;

public class Product {
    private String name;
    private Size size;
    private Color color;
    private int price;
    private ShippingMethod shippingMethod;

    protected Product(String name, Size size, Color color, int price, ShippingMethod shippingMethod) {
        this.name = name;
        this.size = size;
        this.color = color;
        this.price = price;
        this.shippingMethod = shippingMethod;
    }

    // getter, setter
    protected void setSize(Size size) {
        this.size = size;
    }

    protected void setColor(Color color) {
        this.color = color;
    }

    protected void setPrice(int price) {
        this.price = price;
    }

    protected void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}
