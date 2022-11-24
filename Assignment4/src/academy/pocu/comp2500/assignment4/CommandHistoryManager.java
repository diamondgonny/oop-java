package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class CommandHistoryManager {
    private Canvas canvas;
    private ArrayList<ICommand> canUndoCommands = new ArrayList<>();
    private ArrayList<ICommand> canRedoCommands = new ArrayList<>();

    public CommandHistoryManager(Canvas canvas) {
        this.canvas = canvas;
    }

    public boolean execute(ICommand command) {
        // 지정된 커맨드를 캔버스에 적용합니다.
        // 만약에 redo()를 호출하기 전에 완전히 새로운 커맨드가 캔버스에 적용되었다면, redo를 할 수 없음

        // execute fail?
        if (command.execute(canvas)) {
            canUndoCommands.add(command);
            canRedoCommands.clear();
            return true;
        }
        return false;
    }

    public boolean canUndo() {
        return !canUndoCommands.isEmpty();
    }

    public boolean canRedo() {
        return !canRedoCommands.isEmpty();
    }

    public boolean undo() {
        // 가장 최근에 캔버스에 적용했던 커맨드 undo
        if (!canUndo()) {
            return false;
        }
        ICommand command = canUndoCommands.get(canUndoCommands.size() - 1);
        command.undo();
        canRedoCommands.add(command);
        canUndoCommands.remove(canUndoCommands.size() - 1);
        return true;
    }

    public boolean redo() {
        // 가장 최근에 실행 취소된 커맨드 redo
        if (!canRedo()) {
            return false;
        }
        ICommand command = canRedoCommands.get(canRedoCommands.size() - 1);
        command.redo();
        canUndoCommands.add(command);
        canRedoCommands.remove(canRedoCommands.size() - 1);
        return true;
    }
}
