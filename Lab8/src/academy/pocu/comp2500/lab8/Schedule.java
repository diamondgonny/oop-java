package academy.pocu.comp2500.lab8;

public class Schedule {
    private final int tickStartPoint;
    private final int tickDuration;

    public Schedule(int tickStartPoint, int tickDuration) {
        this.tickStartPoint = tickStartPoint;
        this.tickDuration = tickDuration;
    }

    public int getTickStartPoint() {
        return tickStartPoint;
    }

    public int getTickDuration() {
        return tickDuration;
    }

    public int getTickEndPoint() {
        return tickStartPoint + tickDuration;
    }
}
