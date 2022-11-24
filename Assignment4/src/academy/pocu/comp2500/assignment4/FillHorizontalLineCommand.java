package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class FillHorizontalLineCommand implements ICommand {
    private int y;
    private ArrayList<Character> anteSavedAsciis;
    private char postSavedAscii;
    private Canvas canvas;
    private boolean isExecuted;

    public FillHorizontalLineCommand(int y, char character) {
        this.y = y;
        this.postSavedAscii = character;
    }

    @Override
    public boolean execute(Canvas canvas) {
        // execute fail?
        if (isExecuted) {
            return false;
        }
        this.canvas = canvas;
        for (int x = 0; x < canvas.getWidth(); x++) {
            anteSavedAsciis.add(canvas.getPixel(x, y));
            canvas.drawPixel(x, y, postSavedAscii);
        }
        return isExecuted = true;
    }

    @Override
    public boolean undo() {
        //undo fail?
        for (int x = 0; x < canvas.getWidth(); x++) {
            canvas.drawPixel(x, y, anteSavedAsciis.get(x));
        }
        return true;
    }

    @Override
    public boolean redo() {
        //redo fail?
        for (int x = 0; x < canvas.getWidth(); x++) {
            canvas.drawPixel(x, y, postSavedAscii);
        }
        return true;
    }
}
