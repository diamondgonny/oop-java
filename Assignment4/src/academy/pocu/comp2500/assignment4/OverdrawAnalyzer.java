package academy.pocu.comp2500.assignment4;

import java.util.LinkedList;

public class OverdrawAnalyzer extends Canvas {
    public OverdrawAnalyzer(int width, int height) {
        super(width, height);
    }

    @Override
    public void drawPixel(final int x, final int y, final char ascii) {
    }

    public LinkedList<Character> getPixelHistory(final int x, final int y) {
        final LinkedList<Character> history = new LinkedList<>();
        history.add('0');
        history.add('1');
        return history;
    }

    public int getOverdrawCount(final int x, final int y) {
        return 0;
    }

    public int getOverdrawCount() {
        // total
        return 0;
    }
}
