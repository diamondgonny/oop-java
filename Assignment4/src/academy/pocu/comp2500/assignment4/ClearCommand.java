package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class ClearCommand implements ICommand {
    private ArrayList<ArrayList<Character>> anteSavedAsciis;
    private char postSavedAscii;
    private Canvas canvas;
    private boolean isExecuted;

    public ClearCommand() {
        anteSavedAsciis = new ArrayList<>();
        postSavedAscii = ' ';
        for (int y = 0; y < canvas.getHeight(); y++) {
            anteSavedAsciis.add(new ArrayList<>());
            for (int x = 0; x < canvas.getWidth(); x++) {
                anteSavedAsciis.get(y).add(' ');
            }
        }
    }

    @Override
    public boolean execute(Canvas canvas) {
        // execute fail?
        if (isExecuted) {
            return false;
        }
        this.canvas = canvas;
        for (int y = 0; y < canvas.getHeight(); y++) {
            for (int x = 0; x < canvas.getWidth(); x++) {
                anteSavedAsciis.get(y).add(canvas.getPixel(x, y));
                canvas.drawPixel(x, y, postSavedAscii);
            }
        }
        return isExecuted = true;
    }

    @Override
    public boolean undo() {
        //undo fail?
        for (int y = 0; y < canvas.getHeight(); y++) {
            for (int x = 0; x < canvas.getWidth(); x++) {
                canvas.drawPixel(x, y, anteSavedAsciis.get(y).get(x));
            }
        }
        return true;
    }

    @Override
    public boolean redo() {
        //redo fail?
        for (int y = 0; y < canvas.getHeight(); y++) {
            for (int x = 0; x < canvas.getWidth(); x++) {
                canvas.drawPixel(x, y, postSavedAscii);
            }
        }
        return true;
    }
}
