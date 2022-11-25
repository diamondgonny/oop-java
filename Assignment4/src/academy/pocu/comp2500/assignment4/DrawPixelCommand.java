package academy.pocu.comp2500.assignment4;

public class DrawPixelCommand implements ICommand {
    private final int x;
    private final int y;
    private char anteSavedAscii;
    private char postSavedAscii;
    private Canvas canvas;
    // undo, redo checker?

    public DrawPixelCommand(int x, int y, char character) {
        this.x = x;
        this.y = y;
        this.postSavedAscii = character;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (!(0 <= x && x < canvas.getWidth()) || !(0 <= y && y < canvas.getHeight()) ||
                this.canvas != null) {
            return false;
        }
        this.canvas = canvas;
        anteSavedAscii = canvas.getPixel(x, y);
        canvas.drawPixel(x, y, postSavedAscii);
        return true;
    }

    @Override
    public boolean undo() {
        //undo fail?
        canvas.drawPixel(x, y, anteSavedAscii);
        return true;
    }

    @Override
    public boolean redo() {
        //redo fail?
        canvas.drawPixel(x, y, postSavedAscii);
        return true;
    }
}
