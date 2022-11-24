package academy.pocu.comp2500.assignment4.app;

import academy.pocu.comp2500.assignment4.Canvas;

public class Program {

    public static void main(String[] args) {
	    // write your code here
        Canvas canvas = new Canvas(10, 10);

        canvas.drawPixel(0, 0, '*');
        canvas.drawPixel(1, 2, '$');
        canvas.drawPixel(0, 1, '&');

        System.out.println(canvas.getDrawing());
    }
}
