package academy.pocu.comp2500.assignment2;

public enum BusinessCardColor {
    GRAY(new Color((short) 0xe6, (short) 0xe6, (short) 0xe6)),
    IVORY(new Color((short) 0xff, (short) 0xff, (short) 0xf0)),
    WHITE(new Color((short) 0xff, (short) 0xff, (short) 255));

    private final Color color;

    private BusinessCardColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
