package academy.pocu.comp2500.assignment4;

public class ToLowercaseCommand implements ICommand {
    private final int x;
    private final int y;
    private char anteSavedAscii;
    private char postSavedAscii;
    private Canvas canvas;
    private boolean undoable;
    private boolean redoable;

    public ToLowercaseCommand(int x, int y) {
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
        canvas.toLower(x, y);
        postSavedAscii = canvas.getPixel(x, y);
        return undoable = true;
    }

    @Override
    public boolean undo() {
        if (!undoable) {
            return false;
        }
        canvas.drawPixel(x, y, anteSavedAscii);
        undoable = false;
        return redoable = true;
    }

    @Override
    public boolean redo() {
        if (!redoable) {
            return false;
        }
        canvas.drawPixel(x, y, postSavedAscii);
        redoable = false;
        return undoable = true;
    }
}
