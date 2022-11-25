package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class FillVerticalLineCommand implements ICommand {
    private int x;
    private ArrayList<Character> anteSavedAsciis;
    private char postSavedAscii;
    private Canvas canvas;
    private boolean isExecuted;

    public FillVerticalLineCommand(int x, char character) {
        this.x = x;
        this.anteSavedAsciis = new ArrayList<>();
        this.postSavedAscii = character;
    }

    @Override
    public boolean execute(Canvas canvas) {
        // execute fail?
        if (isExecuted) {
            return false;
        }
        this.canvas = canvas;
        for (int y = 0; y < canvas.getHeight(); y++) {
            anteSavedAsciis.add(canvas.getPixel(x, y));
            canvas.drawPixel(x, y, postSavedAscii);
        }
        return isExecuted = true;
    }

    @Override
    public boolean undo() {
        //undo fail?
        for (int y = 0; y < canvas.getHeight(); y++) {
            canvas.drawPixel(x, y, anteSavedAsciis.get(y));
        }
        return true;
    }

    @Override
    public boolean redo() {
        //redo fail?
        for (int y = 0; y < canvas.getHeight(); y++) {
            canvas.drawPixel(x, y, postSavedAscii);
        }
        return true;
    }
}
