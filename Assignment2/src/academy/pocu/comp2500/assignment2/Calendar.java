package academy.pocu.comp2500.assignment2;

public class Calendar extends Product {
    private CalendarType type;

    public Calendar(CalendarType type, ShippingMethod shippingMethod) {
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

        super.setName(String.format("%s Calendar", calendarType));
        super.setSize(calendarSize);
        super.setColor(new Color(0xff, 0xff, 0xff));
        super.setPrice(calendarPrice);
        super.setShippingMethod(shippingMethod);
        this.type = type;
    }

    public CalendarType getType() {
        return type;
    }
}
