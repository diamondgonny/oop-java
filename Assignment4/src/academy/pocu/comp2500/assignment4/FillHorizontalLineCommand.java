package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class FillHorizontalLineCommand implements ICommand {
    private int y;
    private ArrayList<Character> anteSavedAsciis;
    private char postSavedAscii;
    private Canvas canvas;
    private boolean undoable;
    private boolean redoable;

    public FillHorizontalLineCommand(int y, char character) {
        this.y = y;
        this.anteSavedAsciis = new ArrayList<>();
        this.postSavedAscii = character;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (!(0 <= y && y < canvas.getHeight()) || this.canvas != null) {
            return false;
        }

        this.canvas = canvas;
        for (int x = 0; x < canvas.getWidth(); x++) {
            anteSavedAsciis.add(canvas.getPixel(x, y));
        }
        canvas.fillHorizontalLine(y, postSavedAscii);
        return undoable = true;
    }

    @Override
    public boolean undo() {
        if (!undoable) {
            return false;
        }
        for (int x = 0; x < canvas.getWidth(); x++) {
            if (canvas.getPixel(x, y) != postSavedAscii) {
                return false;
            }
        }

        for (int x = 0; x < canvas.getWidth(); x++) {
            canvas.drawPixel(x, y, anteSavedAsciis.get(x));
        }
        undoable = false;
        return redoable = true;
    }

    @Override
    public boolean redo() {
        if (!redoable) {
            return false;
        }
        for (int x = 0; x < canvas.getWidth(); x++) {
            if (canvas.getPixel(x, y) != anteSavedAsciis.get(x)) {
                return false;
            }
        }

        for (int x = 0; x < canvas.getWidth(); x++) {
            canvas.drawPixel(x, y, postSavedAscii);
        }
        redoable = false;
        return undoable = true;
    }
}
