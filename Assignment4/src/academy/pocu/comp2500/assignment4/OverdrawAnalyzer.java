package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;
import java.util.LinkedList;

public class OverdrawAnalyzer extends Canvas {
    private ArrayList<ArrayList<LinkedList<Character>>> pixelsHistory;

    public OverdrawAnalyzer(final int width, final int height) {
        super(width, height);
        pixelsHistory = new ArrayList<>();
        for (int y = 0; y < height; y++) {
            pixelsHistory.add(new ArrayList<>());
            for (int x = 0; x < width; x++) {
                pixelsHistory.get(y).add(new LinkedList<>());
            }
        }
    }

    @Override
    public void drawPixel(final int x, final int y, final char character) {
        if (getPixel(x, y) == character) {
            return;
        }
        super.drawPixel(x, y, character);
        // set history (executeV, undo, redo)
        pixelsHistory.get(y).get(x).add(character);
    }

    public LinkedList<Character> getPixelHistory(final int x, final int y) {
        final LinkedList<Character> pixelHistory = pixelsHistory.get(y).get(x);
        return pixelHistory;
    }

    public int getOverdrawCount(final int x, final int y) {
        int overdrawCount = pixelsHistory.get(y).get(x).size();
        return overdrawCount;
    }

    public int getOverdrawCount() {
        int overdrawCount = 0;
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                overdrawCount += pixelsHistory.get(y).get(x).size();
            }
        }
        return overdrawCount;
    }
}
