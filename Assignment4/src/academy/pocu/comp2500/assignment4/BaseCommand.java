package academy.pocu.comp2500.assignment4;

public abstract class BaseCommand implements ICommand {
    protected int cmdX;
    protected int cmdY;
    protected boolean canUndo;
    protected boolean canRedo;
    protected char anteSavedAscii;
    protected char postSavedAscii;
    protected Canvas canvas;

    public abstract boolean execute(Canvas canvas);

    public boolean undo() {
        if (!canUndo || canvas.getPixel(cmdX, cmdY) != postSavedAscii) {
            return false;
        }

        canvas.drawPixel(cmdX, cmdY, anteSavedAscii);
        canUndo = false;
        return canRedo = true;
    }

    public boolean redo() {
        if (!canRedo || canvas.getPixel(cmdX, cmdY) != anteSavedAscii) {
            return false;
        }

        canvas.drawPixel(cmdX, cmdY, postSavedAscii);
        canRedo = false;
        return canUndo = true;
    }

    protected boolean isAlreadyExecuted() {
        return this.canvas != null;
    }

    protected boolean isValidRangeOfX(final Canvas canvas, final int x) {
        return 0 <= x && x < canvas.getWidth();
    }

    protected boolean isValidRangeOfY(final Canvas canvas, final int y) {
        return 0 <= y && y < canvas.getHeight();
    }
}
