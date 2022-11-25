package academy.pocu.comp2500.assignment4.app;

import academy.pocu.comp2500.assignment4.Canvas;
import academy.pocu.comp2500.assignment4.ClearCommand;
import academy.pocu.comp2500.assignment4.CommandHistoryManager;
import academy.pocu.comp2500.assignment4.DecreasePixelCommand;
import academy.pocu.comp2500.assignment4.DrawPixelCommand;
import academy.pocu.comp2500.assignment4.FillHorizontalLineCommand;
import academy.pocu.comp2500.assignment4.FillVerticalLineCommand;
import academy.pocu.comp2500.assignment4.IncreasePixelCommand;
import academy.pocu.comp2500.assignment4.OverdrawAnalyzer;
import academy.pocu.comp2500.assignment4.ToLowercaseCommand;
import academy.pocu.comp2500.assignment4.ToUppercaseCommand;

public class Test {
    public static void testUpperLowerUndo() {
        Canvas canvas = new Canvas(5, 5);
        CommandHistoryManager manager = new CommandHistoryManager(canvas);

        ToUppercaseCommand upper1 = new ToUppercaseCommand(1, 1);
        assert (manager.execute(upper1));
        assert (canvas.getPixel(1, 1) == ' ');
        assert (manager.undo());
        assert (canvas.getPixel(1, 1) == ' ');
        DrawPixelCommand draw1 = new DrawPixelCommand(1, 1, 'c');
        DrawPixelCommand draw2 = new DrawPixelCommand(1, 2, 'C');
        manager.execute(draw1);
        manager.execute(draw2);
        ToUppercaseCommand upper2 = new ToUppercaseCommand(1, 1);
        ToUppercaseCommand upper3 = new ToUppercaseCommand(1, 2);
        assert (manager.execute(upper2));
        assert (canvas.getPixel(1, 1) == 'C');
        assert (manager.execute(upper3));
        assert (canvas.getPixel(1, 2) == 'C');
        assert (manager.undo());
        assert (manager.undo());
        assert (canvas.getPixel(1, 1) == 'c');
        assert (canvas.getPixel(1, 2) == 'C');
    }

    public static void testOverdrawCount() {
        OverdrawAnalyzer canvas = new OverdrawAnalyzer(5, 5);
        CommandHistoryManager manager = new CommandHistoryManager(canvas);

        DrawPixelCommand drawPixelCommand = new DrawPixelCommand(2, 1, 'X');
        manager.execute(drawPixelCommand);
        IncreasePixelCommand increasePixelCommand = new IncreasePixelCommand(0, 1);
        manager.execute(increasePixelCommand);
        FillVerticalLineCommand fillVerticalLineCommand = new FillVerticalLineCommand(3, '9');
        manager.execute(fillVerticalLineCommand);
        ToUppercaseCommand toUppercaseCommand = new ToUppercaseCommand(1, 3);
        manager.execute(toUppercaseCommand);
        ToUppercaseCommand toUppercaseCommand1 = new ToUppercaseCommand(0, 4);
        manager.execute(toUppercaseCommand1);
        FillHorizontalLineCommand fillHorizontalLineCommand = new FillHorizontalLineCommand(2, '4');
        manager.execute(fillHorizontalLineCommand);
        manager.undo();
        FillVerticalLineCommand fillVerticalLineCommand1 = new FillVerticalLineCommand(2, 'B');
        manager.execute(fillVerticalLineCommand1);
        ClearCommand clearCommand = new ClearCommand();
        manager.execute(clearCommand);
        ToLowercaseCommand toLowercaseCommand = new ToLowercaseCommand(3, 1);
        manager.execute(toLowercaseCommand);
        manager.undo();
        ToUppercaseCommand toUppercaseCommand2 = new ToUppercaseCommand(1, 2);
        manager.execute(toUppercaseCommand2);
        FillVerticalLineCommand fillVerticalLineCommand2 = new FillVerticalLineCommand(2, '8');
        manager.execute(fillVerticalLineCommand2);
        manager.undo();
        FillHorizontalLineCommand fillHorizontalLineCommand1 = new FillHorizontalLineCommand(2, 'F');
        manager.execute(fillHorizontalLineCommand1);
        ToLowercaseCommand toLowercaseCommand1 = new ToLowercaseCommand(1, 2);
        manager.execute(toLowercaseCommand1);
        ToUppercaseCommand toUppercaseCommand3 = new ToUppercaseCommand(0, 0);
        manager.execute(toUppercaseCommand3);
        ClearCommand clearCommand1 = new ClearCommand();
        manager.execute(clearCommand1);
        DecreasePixelCommand decreasePixelCommand = new DecreasePixelCommand(3, 2);
        manager.execute(decreasePixelCommand);
        FillVerticalLineCommand fillVerticalLineCommand3 = new FillVerticalLineCommand(4, 'k');
        manager.execute(fillVerticalLineCommand3);

        System.out.println(canvas.getOverdrawCount());
        assert (canvas.getOverdrawCount() == 59);
    }

    public static void testOverdrawCountXY() {
        OverdrawAnalyzer canvas = new OverdrawAnalyzer(5, 5);
        CommandHistoryManager manager = new CommandHistoryManager(canvas);
        FillHorizontalLineCommand horizontal = new FillHorizontalLineCommand(1, 'J');
        manager.execute(horizontal);
        ToLowercaseCommand lower = new ToLowercaseCommand(4, 1);
        manager.execute(lower);

        assert (canvas.getOverdrawCount(4, 1) == 2);
    }

    public static void overdrawCount() {
        OverdrawAnalyzer canvas = new OverdrawAnalyzer(5, 5);
        CommandHistoryManager manager = new CommandHistoryManager(canvas);
        ToUppercaseCommand upper1 = new ToUppercaseCommand(2, 0);
        manager.execute(upper1);
        ToUppercaseCommand upper2 = new ToUppercaseCommand(0, 1);
        manager.execute(upper2);
        ToLowercaseCommand lower1 = new ToLowercaseCommand(4, 3);
        manager.execute(lower1);
        FillHorizontalLineCommand horizontal = new FillHorizontalLineCommand(0, 'e');
        manager.execute(horizontal);
        DecreasePixelCommand decrease1 = new DecreasePixelCommand(4, 4);
        manager.execute(decrease1);
        DecreasePixelCommand decrease2 = new DecreasePixelCommand(0, 1);
        manager.execute(decrease2);
        ToLowercaseCommand lower2 = new ToLowercaseCommand(0, 0);
        manager.execute(lower2);
        DrawPixelCommand draw = new DrawPixelCommand(3, 2, 'Z');
        manager.execute(draw);
        IncreasePixelCommand increase = new IncreasePixelCommand(3, 4);
        manager.execute(increase);
        ToUppercaseCommand upper3 = new ToUppercaseCommand(4, 4);
        manager.execute(upper3);
        DrawPixelCommand draw2 = new DrawPixelCommand(4, 0, '+');
        manager.execute(draw2);
        FillVerticalLineCommand vertical = new FillVerticalLineCommand(4, '^');
        manager.execute(vertical);
        ToLowercaseCommand lower3 = new ToLowercaseCommand(0, 3);
        manager.execute(lower3);
        ToLowercaseCommand lower4 = new ToLowercaseCommand(1, 0);
        manager.execute(lower4);
        manager.redo();
        manager.undo();
        ToLowercaseCommand lower5 = new ToLowercaseCommand(1, 3);
        manager.execute(lower5);
        FillVerticalLineCommand vertical3 = new FillVerticalLineCommand(3, 'I');
        manager.execute(vertical3);
        IncreasePixelCommand increasePixelCommand = new IncreasePixelCommand(4, 4);
        manager.execute(increasePixelCommand);
        manager.redo();

        assert (canvas.getOverdrawCount() == 19);
    }

    public static void overdrawCount2() {
        OverdrawAnalyzer canvas = new OverdrawAnalyzer(5, 5);
        CommandHistoryManager manager = new CommandHistoryManager(canvas);
        manager.undo();
        ToUppercaseCommand toUppercaseCommand = new ToUppercaseCommand(3, 4);
        manager.execute(toUppercaseCommand);
        ToLowercaseCommand toLowercaseCommand = new ToLowercaseCommand(0, 1);
        manager.execute(toLowercaseCommand);
        ClearCommand clearCommand = new ClearCommand();
        manager.execute(clearCommand);
        IncreasePixelCommand increasePixelCommand = new IncreasePixelCommand(2, 2);
        manager.execute(increasePixelCommand);
        DecreasePixelCommand decreasePixelCommand = new DecreasePixelCommand(1, 3);
        manager.execute(decreasePixelCommand);
        IncreasePixelCommand increasePixelCommand1 = new IncreasePixelCommand(1, 2);
        manager.execute(increasePixelCommand1);
        manager.undo();
        manager.undo();
        ClearCommand clearCommand1 = new ClearCommand();
        manager.execute(clearCommand1);
        FillHorizontalLineCommand fillHorizontalLineCommand = new FillHorizontalLineCommand(4, 'p');
        manager.execute(fillHorizontalLineCommand);
        manager.redo();
        manager.undo();
        IncreasePixelCommand increasePixelCommand2 = new IncreasePixelCommand(2, 1);
        manager.execute(increasePixelCommand2);
        IncreasePixelCommand increasePixelCommand3 = new IncreasePixelCommand(3, 1);
        manager.execute(increasePixelCommand3);
        ToUppercaseCommand toUppercaseCommand1 = new ToUppercaseCommand(2, 2);
        manager.execute(toUppercaseCommand1);
        manager.undo();
        FillHorizontalLineCommand fillHorizontalLineCommand1 = new FillHorizontalLineCommand(0, ' ');
        manager.execute(fillHorizontalLineCommand1);
        manager.undo();
        FillHorizontalLineCommand fillHorizontalLineCommand2 = new FillHorizontalLineCommand(4, 'D');
        manager.execute(fillHorizontalLineCommand2);

        assert (canvas.getOverdrawCount() == 21);
    }

    public static void testPixelHistory() {
        OverdrawAnalyzer canvas = new OverdrawAnalyzer(5, 5);
        CommandHistoryManager manager = new CommandHistoryManager(canvas);
        FillHorizontalLineCommand fillHorizontalLineCommand = new FillHorizontalLineCommand(0, 'z');
        manager.execute(fillHorizontalLineCommand);
        manager.redo();
        ToLowercaseCommand toLowercaseCommand = new ToLowercaseCommand(1, 4);
        manager.execute(toLowercaseCommand);
        FillVerticalLineCommand fillVerticalLineCommand = new FillVerticalLineCommand(2, ' ');
        manager.execute(fillVerticalLineCommand);
        IncreasePixelCommand increasePixelCommand = new IncreasePixelCommand(1, 4);
        manager.execute(increasePixelCommand);
        ClearCommand clearCommand = new ClearCommand();
        manager.execute(clearCommand);
        DrawPixelCommand drawPixelCommand = new DrawPixelCommand(1, 1, 'Z');
        manager.execute(drawPixelCommand);
        ToLowercaseCommand toLowercaseCommand1 = new ToLowercaseCommand(3, 1);
        manager.execute(toLowercaseCommand1);
        ToUppercaseCommand toUppercaseCommand = new ToUppercaseCommand(1, 0);
        manager.execute(toUppercaseCommand);
        ToLowercaseCommand toLowercaseCommand2 = new ToLowercaseCommand(3, 3);
        manager.execute(toLowercaseCommand2);
        ClearCommand clearCommand1 = new ClearCommand();
        manager.execute(clearCommand1);
        FillVerticalLineCommand fillVerticalLineCommand1 = new FillVerticalLineCommand(0, 'K');
        manager.execute(fillVerticalLineCommand1);
        FillVerticalLineCommand fillVerticalLineCommand2 = new FillVerticalLineCommand(0, 'I');
        manager.execute(fillVerticalLineCommand2);
        FillVerticalLineCommand fillVerticalLineCommand3 = new FillVerticalLineCommand(4, ',');
        manager.execute(fillVerticalLineCommand3);
        IncreasePixelCommand increasePixelCommand1 = new IncreasePixelCommand(3, 0);
        manager.execute(increasePixelCommand1);
        ToLowercaseCommand toLowercaseCommand3 = new ToLowercaseCommand(4, 3);
        manager.execute(toLowercaseCommand3);
        DecreasePixelCommand decreasePixelCommand = new DecreasePixelCommand(1, 1);
        manager.execute(decreasePixelCommand);
        manager.redo();
        DecreasePixelCommand decreasePixelCommand1 = new DecreasePixelCommand(0, 3);
        manager.execute(decreasePixelCommand1);
        DecreasePixelCommand decreasePixelCommand2 = new DecreasePixelCommand(4, 4);
        manager.execute(decreasePixelCommand2);

        System.out.println(canvas.getPixelHistory(2, 1));
    }

    public static void overdrawCount3() {
        OverdrawAnalyzer canvas = new OverdrawAnalyzer(5, 5);
        CommandHistoryManager manager = new CommandHistoryManager(canvas);

        FillVerticalLineCommand fillVerticalLineCommand = new FillVerticalLineCommand(1, 'k');
        manager.execute(fillVerticalLineCommand);
        IncreasePixelCommand increasePixelCommand = new IncreasePixelCommand(3, 2);
        manager.execute(increasePixelCommand);
        FillHorizontalLineCommand fillHorizontalLineCommand = new FillHorizontalLineCommand(0, ' ');
        manager.execute(fillHorizontalLineCommand);
        DecreasePixelCommand decreasePixelCommand = new DecreasePixelCommand(4, 2);
        manager.execute(decreasePixelCommand);
        ToUppercaseCommand toUppercaseCommand = new ToUppercaseCommand(4, 2);
        manager.execute(toUppercaseCommand);
        ToLowercaseCommand toLowercaseCommand = new ToLowercaseCommand(2, 1);
        manager.execute(toLowercaseCommand);
        FillHorizontalLineCommand fillHorizontalLineCommand1 = new FillHorizontalLineCommand(0, 'b');
        manager.execute(fillHorizontalLineCommand1);
        FillVerticalLineCommand fillVerticalLineCommand1 = new FillVerticalLineCommand(1, 'C');
        manager.execute(fillVerticalLineCommand1);
        DrawPixelCommand drawPixelCommand = new DrawPixelCommand(4, 0, 'b');
        manager.execute(drawPixelCommand);
        IncreasePixelCommand increasePixelCommand1 = new IncreasePixelCommand(4, 2);
        manager.execute(increasePixelCommand1);
        ToLowercaseCommand toLowercaseCommand1 = new ToLowercaseCommand(4, 4);
        manager.execute(toLowercaseCommand1);
        ClearCommand clearCommand = new ClearCommand();
        manager.execute(clearCommand);
        IncreasePixelCommand increasePixelCommand2 = new IncreasePixelCommand(1, 1);
        manager.execute(increasePixelCommand2);
        manager.redo();
        ClearCommand clearCommand1 = new ClearCommand();
        manager.execute(clearCommand1);
        ToLowercaseCommand toLowercaseCommand2 = new ToLowercaseCommand(3, 0);
        manager.execute(toLowercaseCommand2);
        ToLowercaseCommand toLowercaseCommand3 = new ToLowercaseCommand(4, 2);
        manager.execute(toLowercaseCommand3);
        DecreasePixelCommand decreasePixelCommand1 = new DecreasePixelCommand(2, 2);
        manager.execute(decreasePixelCommand1);
        FillVerticalLineCommand fillVerticalLineCommand2 = new FillVerticalLineCommand(2, 'h');
        manager.execute(fillVerticalLineCommand2);
        FillHorizontalLineCommand fillHorizontalLineCommand2 = new FillHorizontalLineCommand(1, 'e');
        manager.execute(fillHorizontalLineCommand2);

        assert (canvas.getOverdrawCount() == 41);
    }

    public static void sampleTest() {
        OverdrawAnalyzer canvas = new OverdrawAnalyzer(5, 5);
        CommandHistoryManager manager = new CommandHistoryManager(canvas);

        IncreasePixelCommand increasePixelCommand = new IncreasePixelCommand(1, 3);
        manager.execute(increasePixelCommand);
        manager.undo();
        DrawPixelCommand drawPixelCommand = new DrawPixelCommand(1, 3, '+');
        manager.execute(drawPixelCommand);
        ClearCommand clearCommand = new ClearCommand();
        manager.execute(clearCommand);

        assert (canvas.getOverdrawCount() == 4);
    }

    public static void sampleTest2() {
        OverdrawAnalyzer canvas = new OverdrawAnalyzer(5, 5);
        CommandHistoryManager manager = new CommandHistoryManager(canvas);

        FillHorizontalLineCommand fillHorizontalLineCommand = new FillHorizontalLineCommand(0, 'J');
        manager.execute(fillHorizontalLineCommand);
        ClearCommand clearCommand = new ClearCommand();
        manager.execute(clearCommand);
        manager.undo();
        ClearCommand clearCommand1 = new ClearCommand();
        manager.execute(clearCommand1);

        System.out.println(canvas.getPixelHistory(0, 0));
    }
}
