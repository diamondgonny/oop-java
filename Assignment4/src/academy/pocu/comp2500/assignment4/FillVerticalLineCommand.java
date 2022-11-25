package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class FillVerticalLineCommand implements ICommand {
    private int x;
    private ArrayList<Character> anteSavedAsciis;
    private char postSavedAscii;
    private Canvas canvas;
    private boolean undoable;
    private boolean redoable;

    public FillVerticalLineCommand(int x, char character) {
        this.x = x;
        this.anteSavedAsciis = new ArrayList<>();
        this.postSavedAscii = character;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (!(0 <= x && x < canvas.getWidth()) || this.canvas != null) {
            return false;
        }

        this.canvas = canvas;
        for (int y = 0; y < canvas.getHeight(); y++) {
            anteSavedAsciis.add(canvas.getPixel(x, y));
        }
        canvas.fillVerticalLine(x, postSavedAscii);
        return undoable = true;
    }

    @Override
    public boolean undo() {
        if (!undoable) {
            return false;
        }
        for (int y = 0; y < canvas.getHeight(); y++) {
            if (canvas.getPixel(x, y) != postSavedAscii) {
                return false;
            }
        }

        for (int y = 0; y < canvas.getHeight(); y++) {
            canvas.drawPixel(x, y, anteSavedAsciis.get(y));
        }
        undoable = false;
        return redoable = true;
    }

    @Override
    public boolean redo() {
        if (!redoable) {
            return false;
        }
        for (int y = 0; y < canvas.getHeight(); y++) {
            if (canvas.getPixel(x, y) != anteSavedAsciis.get(y)) {
                return false;
            }
        }

        for (int y = 0; y < canvas.getHeight(); y++) {
            canvas.drawPixel(x, y, postSavedAscii);
        }
        redoable = false;
        return undoable = true;
    }
}
