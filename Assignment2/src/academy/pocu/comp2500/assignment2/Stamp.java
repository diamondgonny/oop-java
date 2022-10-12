package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private String text;

    public Stamp(StampSize size, StampColor color, String text, ShippingMethod shippingMethod) {
        super("Stamp", size.getSize(), color.getColor(), size.getPrice(), shippingMethod);
        this.text = text;
    }

    /*
    public void setSize(StampSize size) {
        this.setSize(size.getSize());
        this.setPrice(size.getPrice());
    }
     */

    public void setText(String text) {
        this.text = text;
    }
}
