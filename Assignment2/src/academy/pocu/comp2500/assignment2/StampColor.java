package academy.pocu.comp2500.assignment2;

public enum StampColor {
    RED(new Color(0xff, 0, 0)),
    BLUE(new Color(0, 0, 0xff)),
    GREEN(new Color(0, 0x80, 0));

    private final Color color;

    StampColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
