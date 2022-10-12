package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private CalendarType type;

    public Calendar(CalendarType type, ShippingMethod shippingMethod) {
        super("Calendar", type.getSize(), new Color(0xff, 0xff, 0xff), type.getPrice(), shippingMethod);
        this.type = type;
    }

    public void setCalendarType(CalendarType type) {
        this.setSize(type.getSize());
        this.setPrice(type.getPrice());
        this.type = type;
    }
}
