package academy.pocu.comp2500.assignment2;

public class Color {
    private short red;
    private short green;
    private short blue;

    public Color(int red, int green, int blue) {
        if (0 <= red && red <= 255 && 0 <= green && green <= 255 && 0 <= blue && blue <= 255) {
            this.red = (short) red;
            this.green = (short) green;
            this.blue = (short) blue;
        } else {
            assert (false) : "invalid color";
        }
    }

    public int getRgbColor() {
        // How to use : System.out.format("0x%06x\n", item.getColor().getRgbColor());
        return (int) red * 0x10000 + (int) green * 0x100 + (int) blue;
    }
}
