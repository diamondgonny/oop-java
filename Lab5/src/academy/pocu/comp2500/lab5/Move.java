package academy.pocu.comp2500.lab5;

public class Move {
    private String name;
    private int power;
    private int maxPowerCount;

    public Move(String name, int power, int maxPowerCount) {
        this.name = name;
        this.power = power;
        this.maxPowerCount = maxPowerCount;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public int getMaxPowerCount() {
        return maxPowerCount;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void addPower(int power) {
        this.power = (this.power + power < this.maxPowerCount) ? this.power + power : this.maxPowerCount;
    }
}
