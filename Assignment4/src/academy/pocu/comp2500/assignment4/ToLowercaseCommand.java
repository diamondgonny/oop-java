package academy.pocu.comp2500.assignment4;

public class ToLowercaseCommand extends BaseCommand {
    public ToLowercaseCommand(int x, int y) {
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
        canvas.toLower(cmdX, cmdY);
        postSavedAscii = canvas.getPixel(cmdX, cmdY);
        return undoableOrder = true;
    }
}
