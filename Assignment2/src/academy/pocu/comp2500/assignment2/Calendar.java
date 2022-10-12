package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private CalendarType type;

    public Calendar(CalendarType type, ShippingMethod shippingMethod) {
        super(type.getSize(), new Color(0xff, 0xff, 0xff), type.getPrice(), shippingMethod);
        String name = String.format("%s Calendar", type.getType());
        super.setName(name);
        this.type = type;
    }

    public CalendarType getType() {
        return type;
    }
}
