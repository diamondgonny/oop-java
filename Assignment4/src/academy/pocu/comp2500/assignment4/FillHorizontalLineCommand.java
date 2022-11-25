package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class FillHorizontalLineCommand extends BaseCommand {
    private ArrayList<Character> anteSavedAsciis;

    public FillHorizontalLineCommand(int y, char character) {
        this.cmdY = y;
        this.anteSavedAsciis = new ArrayList<>();
        this.postSavedAscii = character;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (!isValidRangeOfY(canvas, cmdY) || isAlreadyExecuted()) {
            return false;
        }

        this.canvas = canvas;
        for (int x = 0; x < canvas.getWidth(); x++) {
            anteSavedAsciis.add(canvas.getPixel(x, cmdY));
            canvas.drawPixel(x, cmdY, postSavedAscii);
        }
        return undoableOrder = true;
    }

    @Override
    public boolean undo() {
        if (!undoableOrder) {
            return false;
        }
        for (int x = 0; x < canvas.getWidth(); x++) {
            if (canvas.getPixel(x, cmdY) != postSavedAscii) {
                return false;
            }
        }

        for (int x = 0; x < canvas.getWidth(); x++) {
            canvas.drawPixel(x, cmdY, anteSavedAsciis.get(x));
        }
        undoableOrder = false;
        return redoableOrder = true;
    }

    @Override
    public boolean redo() {
        if (!redoableOrder) {
            return false;
        }
        for (int x = 0; x < canvas.getWidth(); x++) {
            if (canvas.getPixel(x, cmdY) != anteSavedAsciis.get(x)) {
                return false;
            }
        }

        for (int x = 0; x < canvas.getWidth(); x++) {
            canvas.drawPixel(x, cmdY, postSavedAscii);
        }
        redoableOrder = false;
        return undoableOrder = true;
    }
}
