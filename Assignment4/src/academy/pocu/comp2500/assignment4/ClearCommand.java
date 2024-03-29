package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class ClearCommand extends BaseCommand {
    private ArrayList<ArrayList<Character>> anteSavedAsciis;
    private final char postSavedAscii;

    public ClearCommand() {
        this.postSavedAscii = ' ';
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (isAlreadyExecuted()) {
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
        return canUndo = true;
    }

    @Override
    public boolean undo() {
        if (!canUndo) {
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
        canUndo = false;
        return canRedo = true;
    }

    @Override
    public boolean redo() {
        if (!canRedo) {
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
        canRedo = false;
        return canUndo = true;
    }
}
