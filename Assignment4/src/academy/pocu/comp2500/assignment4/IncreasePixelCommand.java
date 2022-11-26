package academy.pocu.comp2500.assignment4;

public class IncreasePixelCommand extends BaseCommand {
    public IncreasePixelCommand(final int x, final int y) {
        this.cmdX = x;
        this.cmdY = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (!isValidRangeOfX(canvas, cmdX) || !isValidRangeOfY(canvas, cmdY) || isAlreadyExecuted()) {
            return false;
        }

        this.canvas = canvas;
        anteSavedAscii = canvas.getPixel(cmdX, cmdY);
        if (canvas.increasePixel(cmdX, cmdY)) {
            postSavedAscii = (char) (anteSavedAscii + 1);
            return canUndo = true;
        }
        return false;
    }
}
