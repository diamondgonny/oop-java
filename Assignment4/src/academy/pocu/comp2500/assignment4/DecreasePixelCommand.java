package academy.pocu.comp2500.assignment4;

public class DecreasePixelCommand implements ICommand {
    private final int x;
    private final int y;
    private char anteSavedAscii;
    private char postSavedAscii;
    private Canvas canvas;

    public DecreasePixelCommand(int x, int y) {
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
        postSavedAscii = (char) (anteSavedAscii - 1);
//        canvas.drawPixel(x, y, postSavedAscii);
        canvas.decreasePixel(x, y);
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
