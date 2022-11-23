package academy.pocu.comp2500.assignment4;

public class DrawPixelCommand {
    private int x;
    private int y;
    private char ascii;

    public DrawPixelCommand(int x, int y, char ascii) {
        this.x = x;
        this.y = y;
        this.ascii = ascii;
    }

    public boolean execute(Canvas canvas) {
        // execute fail?
        canvas.drawPixel(x, y, ascii);
        return true;
    }

    public boolean undo() {
        //undo fail?

        return true;
    }

    public boolean redo() {
        //redo fail?
        
        return true;
    }
}
