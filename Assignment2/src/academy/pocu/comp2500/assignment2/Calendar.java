package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private CalendarType type;

    public Calendar(CalendarType type, Shipment shipment) {
        super("Calendar", type.getSize(), new Color(0xff, 0xff, 0xff), type.getPrice(), shipment);
        this.type = type;
    }

    public void setCalendarType(CalendarType type) {
        this.setSize(type.getSize());
        this.setPrice(type.getPrice());
        this.type = type;
    }

    public void setShippingMethod(Shipment shipment) {
        this.setShippingMethod(shipment);
    }
}
