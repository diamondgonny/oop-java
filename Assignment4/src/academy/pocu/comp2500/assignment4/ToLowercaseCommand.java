package academy.pocu.comp2500.assignment4;

public class ToLowercaseCommand extends BaseCommand {
    public ToLowercaseCommand(final int x, final int y) {
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
        canvas.toLower(cmdX, cmdY);
        postSavedAscii = canvas.getPixel(cmdX, cmdY);
        return canUndo = true;
    }
}
