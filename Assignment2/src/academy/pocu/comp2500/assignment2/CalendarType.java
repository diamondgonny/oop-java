package academy.pocu.comp2500.assignment2;

public enum CalendarType {
    WALL(new Size(400, 400), 1000),
    DESK(new Size(200, 150), 1000),
    MAGNET(new Size(100, 200), 1500);

    private final Size size;
    private final int price;

    CalendarType(Size size, int price) {
        this.size = size;
        this.price = price;
    }

    public Size getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }
}
