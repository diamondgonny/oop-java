package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class FillVerticalLineCommand extends BaseCommand {
    private final ArrayList<Character> anteSavedAsciis;

    public FillVerticalLineCommand(final int x, final char character) {
        this.cmdX = x;
        this.anteSavedAsciis = new ArrayList<>();
        this.postSavedAscii = character;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (isAlreadyExecuted() || !isValidRangeOfX(canvas, cmdX)) {
            return false;
        }

        this.canvas = canvas;
        for (int y = 0; y < canvas.getHeight(); y++) {
            anteSavedAsciis.add(canvas.getPixel(cmdX, y));
            canvas.drawPixel(cmdX, y, postSavedAscii);
        }
        return canUndo = true;
    }

    @Override
    public boolean undo() {
        if (!canUndo) {
            return false;
        }
        for (int y = 0; y < canvas.getHeight(); y++) {
            if (canvas.getPixel(cmdX, y) != postSavedAscii) {
                return false;
            }
        }

        for (int y = 0; y < canvas.getHeight(); y++) {
            canvas.drawPixel(cmdX, y, anteSavedAsciis.get(y));
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
            if (canvas.getPixel(cmdX, y) != anteSavedAsciis.get(y)) {
                return false;
            }
        }

        for (int y = 0; y < canvas.getHeight(); y++) {
            canvas.drawPixel(cmdX, y, postSavedAscii);
        }
        canRedo = false;
        return canUndo = true;
    }
}
