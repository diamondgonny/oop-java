package academy.pocu.comp2500.assignment4;

import java.util.Arrays;

public class Canvas {
    private static final char MINIMUM_ASCII_RANGE = 32;
    private static final char MAXIMUM_ASCII_RANGE = 126;

    private int width;
    private int height;
    private char[][] pixels;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new char[width][height];
        Arrays.fill(pixels, ' ');
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void drawPixel(int x, int y, char ascii) {
        pixels[x][y] = ascii;

    }

    public char getPixel(int x, int y) {
        return pixels[x][y];
    }

    public boolean increasePixel(int x, int y) {
        if (pixels[x][y] < MAXIMUM_ASCII_RANGE) {
            ++pixels[x][y];
            return true;
        }
        return false;
    }

    public boolean decreasePixel(int x, int y) {
        if (pixels[x][y] > MINIMUM_ASCII_RANGE) {
            --pixels[x][y];
            return true;
        }
        return false;
    }

    public void toUpper(int x, int y) {
        pixels[x][y] -= 32;
    }

    public void toLower(int x, int y) {
        pixels[x][y] += 32;
    }

    public void fillHorizontalLine(int y, char ascii) {
        // 지정된 행 전체를 지정된 문자로 채워 넣습니다.
    }

    public void fillVerticalLine(int x, char ascii) {
        // 지정된 열 전체를 지정된 문자로 채워 넣습니다.
    }

    public void clear() {
        Arrays.fill(pixels, ' ');
    }

    public void getDrawing() {
        // AADA 그림판
    }
}
