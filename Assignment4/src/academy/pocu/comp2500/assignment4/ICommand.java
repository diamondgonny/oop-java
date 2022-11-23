package academy.pocu.comp2500.assignment4;

public interface ICommand {
    // 이미 execute() 메서드를 호출한 커맨드에서 다시 execute()를 호출할 경우 커맨드는 처리가 되지 않아야 함.
    boolean execute(Canvas canvas);
    boolean undo();
    boolean redo();
}
