package academy.pocu.comp2500.assignment2;

public enum StampColor {
    RED(new Color((short) 0xff, (short) 0, (short) 0)),
    BLUE(new Color((short) 0, (short) 0, (short) 0xff)),
    GREEN(new Color((short) 0, (short) 0x80, (short) 0));

    private final Color color;

    private StampColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
