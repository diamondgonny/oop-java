package academy.pocu.comp2500.assignment4;

public class DrawPixelCommand implements ICommand {
    private final int x;
    private final int y;
    private char anteSavedAscii;
    private char postSavedAscii;
    private Canvas canvas;
    private boolean isExecuted;

    public DrawPixelCommand(int x, int y, char postSavedAscii) {
        this.x = x;
        this.y = y;
        this.postSavedAscii = postSavedAscii;
    }

    @Override
    public boolean execute(Canvas canvas) {
        // execute fail? (out of bounds)
        if (isExecuted) {
            return false;
        }
        this.canvas = canvas;
        anteSavedAscii = canvas.getPixel(x, y);
        canvas.drawPixel(x, y, postSavedAscii);
        return isExecuted = true;
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
