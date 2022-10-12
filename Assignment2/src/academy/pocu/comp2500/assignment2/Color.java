package academy.pocu.comp2500.assignment2;

public class Color {
    private short red;
    private short green;
    private short blue;

    public Color(int red, int green, int blue) {
//        assert(0 <= red && red <= 255);
//        assert(0 <= green && green <= 255);
//        assert(0 <= blue && blue <= 255);
        this.red = (short) Math.max(0, Math.min(red, 255));
        this.green = (short) Math.max(0, Math.min(green, 255));
        this.blue = (short) Math.max(0, Math.min(blue, 255));
    }
}
