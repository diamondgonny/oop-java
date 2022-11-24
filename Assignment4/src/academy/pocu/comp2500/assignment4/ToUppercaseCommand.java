package academy.pocu.comp2500.assignment4;

public class ToUppercaseCommand implements ICommand {
    private final int x;
    private final int y;
    private char anteSavedAscii;
    private char postSavedAscii;
    private Canvas canvas;
    private boolean isExecuted;

    public ToUppercaseCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        // execute fail?
        if (isExecuted) {
            return false;
        }

        this.canvas = canvas;
        anteSavedAscii = canvas.getPixel(x, y);
        if (97 <= canvas.getPixel(x, y) && canvas.getPixel(x, y) <= 122) {
            postSavedAscii = (char) (anteSavedAscii - 32);
            canvas.drawPixel(x, y, postSavedAscii);
        } else {
            postSavedAscii = anteSavedAscii;
            canvas.drawPixel(x, y, postSavedAscii);
        }

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
