package academy.pocu.comp2500.assignment4;

public class ToUppercaseCommand implements ICommand {
    private final int x;
    private final int y;
    private char anteSavedAscii;
    private char postSavedAscii;
    private Canvas canvas;
    private boolean undoable;
    private boolean redoable;

    public ToUppercaseCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (!(0 <= x && x < canvas.getWidth()) || !(0 <= y && y < canvas.getHeight()) ||
                this.canvas != null) {
            return false;
        }

        this.canvas = canvas;
        anteSavedAscii = canvas.getPixel(x, y);
        canvas.toUpper(x, y);
        postSavedAscii = canvas.getPixel(x, y);
        return undoable = true;
    }

    @Override
    public boolean undo() {
        if (!undoable || canvas.getPixel(x, y) != postSavedAscii) {
            return false;
        }
        canvas.drawPixel(x, y, anteSavedAscii);
        undoable = false;
        return redoable = true;
    }

    @Override
    public boolean redo() {
        if (!redoable || canvas.getPixel(x, y) != anteSavedAscii) {
            return false;
        }
        canvas.drawPixel(x, y, postSavedAscii);
        redoable = false;
        return undoable = true;
    }
}
