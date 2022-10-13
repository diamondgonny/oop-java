package academy.pocu.comp2500.assignment2;

public enum StampSize {
    W40H30(new Size(40, 30), 2300),
    W50H20(new Size(50, 20), 2300),
    W70H40(new Size(70, 40), 2600);

    private final Size size;
    private final int price;

    StampSize(Size size, int price) {
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
