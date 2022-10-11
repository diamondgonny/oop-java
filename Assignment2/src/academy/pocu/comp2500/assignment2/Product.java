package academy.pocu.comp2500.assignment2;

public class Product {
    private String name;
    private Size size;
    private Color color;
    private int price;
    private Shipment shipment;

    protected Product(String name, Size size, Color color, Shipment shipment) {
        this.name = name;
        this.size = size;
        this.color = color;
        this.shipment = shipment;
    }

    protected Product(String name, Size size, Color color, int price, Shipment shipment) {
        this(name, size, color, shipment);
        this.price = price;
    }

    // getter, setter

    public Size getSize() {
        return size;
    }

    public int getPrice() {
        return price;
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

    protected void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    protected void addPrice(int price) {
        this.price += price;
    }
}
