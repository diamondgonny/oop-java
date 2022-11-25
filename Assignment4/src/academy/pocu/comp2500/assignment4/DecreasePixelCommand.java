package academy.pocu.comp2500.assignment4;

public class DecreasePixelCommand extends BaseCommand {
    public DecreasePixelCommand(int x, int y) {
        this.cmdX = x;
        this.cmdY = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (isAlreadyExecuted() || !isValidRangeOfX(cmdX) || !isValidRangeOfY(cmdY)) {
            return false;
        }

        this.canvas = canvas;
        anteSavedAscii = canvas.getPixel(cmdX, cmdY);
        if (canvas.decreasePixel(cmdX, cmdY)) {
            postSavedAscii = (char) (anteSavedAscii - 1);
            return undoableOrder = true;
        }
        return false;
    }
}
