package academy.pocu.comp2500.lab5;

public class Move {
    private String name;
    private int power;
    private int maxPowerPoints;

    public Move(String name, int power, int maxPowerPoints) {
        this.name = name;
        this.power = power;
        this.maxPowerPoints = maxPowerPoints;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public void addPower(int power) {
        this.power = (this.power + power < this.maxPowerPoints) ? this.power + power : this.maxPowerPoints;
    }
}
