package academy.pocu.comp2500.assignment2;

public enum BusinessCardColor {
    GRAY(new Color(0xe6, 0xe6, 0xe6)),
    IVORY(new Color(0xff, 0xff, 0xf0)),
    WHITE(new Color(0xff, 0xff, 0xff));

    private final Color color;

    private BusinessCardColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
