package academy.pocu.comp2500.assignment2;

public class Stamp extends Product {
    private final String text;

    public Stamp(StampSize size, StampColor color, String text, ShippingMethod shippingMethod) {
        super(shippingMethod);

        Size stampSize = null;
        Color stampColor = null;
        int stampPrice = 0;

        if (size == StampSize.W40H30) {
            stampSize = new Size(40, 30);
            stampPrice = 2300;
        } else if (size == StampSize.W50H20) {
            stampSize = new Size(50, 20);
            stampPrice = 2300;
        } else if (size == StampSize.W70H40) {
            stampSize = new Size(70, 40);
            stampPrice = 2600;
        } else {
            assert (false) : "unknown size";
        }

        if (color == StampColor.RED) {
            stampColor = new Color(0xff, 0, 0);
        } else if (color == StampColor.BLUE) {
            stampColor = new Color(0, 0, 0xff);
        } else if (color == StampColor.GREEN) {
            stampColor = new Color(0, 0x80, 0);
        } else {
            assert (false) : "unknown color";
        }

        super.name = String.format("Stamp (%d mm x %d mm)", stampSize.getWidth(), stampSize.getHeight());
        super.size = stampSize;
        super.color = stampColor;
        super.price = stampPrice;
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
