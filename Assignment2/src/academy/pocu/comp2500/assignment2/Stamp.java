package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private String text;

    public Stamp(StampSize size, StampColor color, String text, Shipment shipment) {
        super("Stamp", size.getSize(), color.getColor(), size.getPrice(), shipment);
        this.text = text;
    }

    public void setSize(StampSize size) {
        this.setSize(size.getSize());
        this.setPrice(size.getPrice());
    }

    public void setColor(StampColor color) {
        this.setColor(color.getColor());
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setShippingMethod(Shipment shipment) {
        this.setShippingMethod(shipment);
    }
}
