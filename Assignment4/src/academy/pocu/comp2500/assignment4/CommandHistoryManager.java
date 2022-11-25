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
        if (!canUndo()) {
            return false;
        }
        ICommand command = canUndoCommands.get(canUndoCommands.size() - 1);
        if (command.undo()) {
            canRedoCommands.add(command);
            canUndoCommands.remove(canUndoCommands.size() - 1);
            return true;
        }
        return false;
    }

    public boolean redo() {
        if (!canRedo()) {
            return false;
        }
        ICommand command = canRedoCommands.get(canRedoCommands.size() - 1);
        if (command.redo()) {
            canUndoCommands.add(command);
            canRedoCommands.remove(canRedoCommands.size() - 1);
            return true;
        }
        return false;
    }
}
