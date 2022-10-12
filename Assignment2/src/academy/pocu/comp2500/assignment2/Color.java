package academy.pocu.comp2500.assignment2;

public class Color {
    private int red;
    private int green;
    private int blue;

    public Color(int red, int green, int blue) {
//        assert(0 <= red && red <= 255);
//        assert(0 <= green && green <= 255);
//        assert(0 <= blue && blue <= 255);
        this.red = Math.max(0, Math.min(red, 255));
        this.green = Math.max(0, Math.min(green, 255));
        this.blue = Math.max(0, Math.min(blue, 255));
    }
}
