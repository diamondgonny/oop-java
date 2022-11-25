package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class FillVerticalLineCommand extends BaseCommand {
    private ArrayList<Character> anteSavedAsciis;

    public FillVerticalLineCommand(int x, char character) {
        this.cmdX = x;
        this.anteSavedAsciis = new ArrayList<>();
        this.postSavedAscii = character;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (isAlreadyExecuted() || !isValidRangeOfX(cmdX)) {
            return false;
        }

        this.canvas = canvas;
        for (int y = 0; y < canvas.getHeight(); y++) {
            anteSavedAsciis.add(canvas.getPixel(cmdX, y));
            canvas.drawPixel(cmdX, y, postSavedAscii);
        }
        return undoableOrder = true;
    }

    @Override
    public boolean undo() {
        if (!undoableOrder) {
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
        undoableOrder = false;
        return redoableOrder = true;
    }

    @Override
    public boolean redo() {
        if (!redoableOrder) {
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
        redoableOrder = false;
        return undoableOrder = true;
    }
}
