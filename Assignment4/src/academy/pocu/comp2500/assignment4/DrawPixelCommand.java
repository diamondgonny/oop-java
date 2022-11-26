package academy.pocu.comp2500.assignment4;

public class DrawPixelCommand extends BaseCommand {
    public DrawPixelCommand(final int x, final int y, final char character) {
        this.cmdX = x;
        this.cmdY = y;
        this.postSavedAscii = character;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (isAlreadyExecuted() || !isValidRangeOfX(canvas, cmdX) || !isValidRangeOfY(canvas, cmdY)) {
            return false;
        }

        this.canvas = canvas;
        anteSavedAscii = canvas.getPixel(cmdX, cmdY);
        canvas.drawPixel(cmdX, cmdY, postSavedAscii);
        return canUndo = true;
    }
}
