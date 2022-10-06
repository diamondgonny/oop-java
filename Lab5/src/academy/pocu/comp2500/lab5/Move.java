package academy.pocu.comp2500.lab5;

public class Move {
    private String name;
    private int power;
    private int pp;
    private int maxPp;

    public Move(String name, int power, int maxPowerPoints) {
        this.name = name;
        this.power = power;
        this.pp = maxPowerPoints;
        this.maxPp = maxPowerPoints;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public void addPp(int pp) {
        this.pp = (this.pp + pp < this.maxPp) ? this.pp + pp : this.maxPp;
    }
}
