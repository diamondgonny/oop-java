package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class ClearCommand implements ICommand {
    private ArrayList<ArrayList<Character>> anteSavedAsciis;
    private char postSavedAscii = ' ';
    private Canvas canvas;
    private boolean undoable;
    private boolean redoable;

    @Override
    public boolean execute(Canvas canvas) {
        if (this.canvas != null) {
            return false;
        }

        this.canvas = canvas;
        anteSavedAsciis = new ArrayList<>();
        for (int y = 0; y < canvas.getHeight(); y++) {
            anteSavedAsciis.add(new ArrayList<>());
            for (int x = 0; x < canvas.getWidth(); x++) {
                anteSavedAsciis.get(y).add(canvas.getPixel(x, y));
                canvas.drawPixel(x, y, postSavedAscii);
            }
        }
        return undoable = true;
    }

    @Override
    public boolean undo() {
        if (!undoable) {
            return false;
        }
        for (int y = 0; y < canvas.getHeight(); y++) {
            for (int x = 0; x < canvas.getWidth(); x++) {
                if (canvas.getPixel(x, y) != postSavedAscii) {
                    return false;
                }
            }
        }

        for (int y = 0; y < canvas.getHeight(); y++) {
            for (int x = 0; x < canvas.getWidth(); x++) {
                canvas.drawPixel(x, y, anteSavedAsciis.get(y).get(x));
            }
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
            for (int x = 0; x < canvas.getWidth(); x++) {
                if (canvas.getPixel(x, y) != anteSavedAsciis.get(y).get(x)) {
                    return false;
                }
            }
        }

        for (int y = 0; y < canvas.getHeight(); y++) {
            for (int x = 0; x < canvas.getWidth(); x++) {
                canvas.drawPixel(x, y, postSavedAscii);
            }
        }
        redoable = false;
        return undoable = true;
    }
}
