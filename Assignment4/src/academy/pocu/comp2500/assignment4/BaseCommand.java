package academy.pocu.comp2500.assignment4;

public abstract class BaseCommand implements ICommand {
    protected int cmdX;
    protected int cmdY;
    protected char anteSavedAscii;
    protected char postSavedAscii;
    protected Canvas canvas;
    protected boolean undoableOrder;
    protected boolean redoableOrder;

    public abstract boolean execute(Canvas canvas);

    public boolean undo() {
        if (!undoableOrder || canvas.getPixel(cmdX, cmdY) != postSavedAscii) {
            return false;
        }

        canvas.drawPixel(cmdX, cmdY, anteSavedAscii);
        undoableOrder = false;
        return redoableOrder = true;
    }

    public boolean redo() {
        if (!redoableOrder || canvas.getPixel(cmdX, cmdY) != anteSavedAscii) {
            return false;
        }

        canvas.drawPixel(cmdX, cmdY, postSavedAscii);
        redoableOrder = false;
        return undoableOrder = true;
    }

    protected boolean isAlreadyExecuted() {
        return this.canvas != null;
    }

    protected boolean isValidRangeOfX(Canvas canvas, int x) {
        return 0 <= x && x < canvas.getWidth();
    }

    protected boolean isValidRangeOfY(Canvas canvas, int y) {
        return 0 <= y && y < canvas.getHeight();
    }
}
