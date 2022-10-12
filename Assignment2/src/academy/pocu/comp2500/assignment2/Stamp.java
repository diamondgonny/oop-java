package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private String text;

    public Stamp(StampSize size, StampColor color, String text, ShippingMethod shippingMethod) {
        super(size.getSize(), color.getColor(), size.getPrice(), shippingMethod);
        String name = String.format("Stamp (%d mm x %d mm)",
                size.getSize().getWidth(), size.getSize().getHeight());
        super.setName(name);
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
