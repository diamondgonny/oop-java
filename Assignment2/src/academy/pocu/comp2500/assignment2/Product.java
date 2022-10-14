package academy.pocu.comp2500.assignment2;

public class Product {
    private static int productIdCounter;
    private int productId;
    private String name;
    private Size size;
    private Color color;
    private int price;
    private ShippingMethod shippingMethod;

    protected Product(ShippingMethod shippingMethod) {
        ++productIdCounter;
        this.productId = productIdCounter;
        this.shippingMethod = shippingMethod;
    }

    public int getProductId() {
        return productId;
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

    protected void setName(String name) {
        this.name = name;
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
