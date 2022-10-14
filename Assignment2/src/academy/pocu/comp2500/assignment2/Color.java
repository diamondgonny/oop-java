package academy.pocu.comp2500.assignment2;

public class Color {
    private short red;
    private short green;
    private short blue;

    public Color(int red, int green, int blue) {
        this.red = (short) Math.max(0, Math.min(red, 255));
        this.green = (short) Math.max(0, Math.min(green, 255));
        this.blue = (short) Math.max(0, Math.min(blue, 255));
    }

    public int getRgbColor() {
        // How to use : System.out.format("0x%06x\n", item.getColor().getRgbColor());
        return (int) red * 0x10000 + (int) green * 0x100 + (int) blue;
    }
}
