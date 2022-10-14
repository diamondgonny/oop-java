package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private final CalendarType type;

    public Calendar(CalendarType type, ShippingMethod shippingMethod) {
        super(shippingMethod);

        String calendarType = null;
        Size calendarSize = null;
        int calendarPrice = 0;

        if (type == CalendarType.WALL) {
            calendarType = "Wall";
            calendarSize = new Size(400, 400);
            calendarPrice = 1000;
        } else if (type == CalendarType.DESK) {
            calendarType = "Desk";
            calendarSize = new Size(200, 150);
            calendarPrice = 1000;
        } else if (type == CalendarType.MAGNET) {
            calendarType = "Magnet";
            calendarSize = new Size(100, 200);
            calendarPrice = 1500;
        } else {
            assert (false) : "unknown type";
        }

        super.name = String.format("%s Calendar", calendarType);
        super.size = calendarSize;
        super.color = new Color(0xff, 0xff, 0xff);
        super.price = calendarPrice;
        this.type = type;
    }

    public CalendarType getType() {
        return type;
    }
}
