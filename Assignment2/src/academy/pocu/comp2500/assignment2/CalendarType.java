package academy.pocu.comp2500.assignment2;

public enum CalendarType {
    WALL("Wall", new Size(400, 400), 1000),
    DESK("Desk", new Size(200, 150), 1000),
    MAGNET("Magnet", new Size(100, 200), 1500);

    private final String type;
    private final Size size;
    private final int price;

    CalendarType(String type, Size size, int price) {
        this.type = type;
        this.size = size;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public Size getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }
}
