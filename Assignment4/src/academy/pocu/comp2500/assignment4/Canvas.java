package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class Canvas {
    private static final char MINIMUM_ASCII_RANGE = 32;
    private static final char MAXIMUM_ASCII_RANGE = 126;

    private final ArrayList<ArrayList<Character>> pixels;
    private final int width;
    private final int height;

    public Canvas(final int width, final int height) {
        this.width = width;
        this.height = height;
        pixels = new ArrayList<>();
        for (int y = 0; y < height; y++) {
            pixels.add(new ArrayList<>());
            for (int x = 0; x < width; x++) {
                pixels.get(y).add(' ');
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void drawPixel(final int x, final int y, final char character) {
        pixels.get(y).set(x, character);
        assert (MINIMUM_ASCII_RANGE <= pixels.get(y).get(x) &&
                pixels.get(y).get(x) <= MAXIMUM_ASCII_RANGE) : "Invalid ASCII Code Range";
    }

    public char getPixel(final int x, final int y) {
        return pixels.get(y).get(x);
    }

    public boolean increasePixel(final int x, final int y) {
        if (pixels.get(y).get(x) < MAXIMUM_ASCII_RANGE) {
            drawPixel(x, y, (char) (getPixel(x, y) + 1));
            return true;
        }
        return false;
    }

    public boolean decreasePixel(final int x, final int y) {
        if (pixels.get(y).get(x) > MINIMUM_ASCII_RANGE) {
            drawPixel(x, y, (char) (getPixel(x, y) - 1));
            return true;
        }
        return false;
    }

    public void toUpper(final int x, final int y) {
        if (97 <= getPixel(x, y) && getPixel(x, y) <= 122) {
            drawPixel(x, y, (char) (getPixel(x, y) - 32));
        }
    }

    public void toLower(final int x, final int y) {
        if (65 <= getPixel(x, y) && getPixel(x, y) <= 90) {
            drawPixel(x, y, (char) (getPixel(x, y) + 32));
        }
    }

    public void fillHorizontalLine(final int y, final char character) {
        for (int x = 0; x < width; x++) {
            drawPixel(x, y, character);
        }
    }

    public void fillVerticalLine(final int x, final char character) {
        for (int y = 0; y < height; y++) {
            drawPixel(x, y, character);
        }
    }

    public void clear() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                drawPixel(x, y, ' ');
            }
        }
    }

    public String getDrawing() {
        final StringBuilder sb = new StringBuilder();

        addHorizontalBorder(sb);
        for (int y = 0; y < height; y++) {
            sb.append('|');
            for (int x = 0; x < width; x++) {
                sb.append(getPixel(x, y));
            }
            sb.append('|');
            sb.append(System.lineSeparator());
        }
        addHorizontalBorder(sb);

        return sb.toString();
    }

    private void addHorizontalBorder(final StringBuilder sb) {
        sb.append('+');
        for (int i = 0; i < width; ++i) {
            sb.append('-');
        }
        sb.append('+');
        sb.append(System.lineSeparator());
    }
}
