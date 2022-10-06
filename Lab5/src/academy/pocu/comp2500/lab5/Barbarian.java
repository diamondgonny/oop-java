package academy.pocu.comp2500.lab5;

public class Barbarian {
    // private? protected?
    protected String name;
    protected int attack;
    protected int defense;
    protected int hp;
    protected int maxHp;

    public Barbarian(String name, int hp, int attack, int defense) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.hp = hp;
        this.maxHp = hp;
    }

    public int getHp() {
        return this.hp;
    }

    public void attack(Barbarian enemy) {
        if (this.name == enemy.name || !this.isAlive() || !enemy.isAlive()) {
            return;
        }
        double damageForCalc = ((double) this.attack - (double) enemy.defense) / 2;
        int damage = (int) damageForCalc;
        enemy.hp = (damage > 1) ? enemy.hp - damage : enemy.hp - 1;
        enemy.hp = (enemy.hp > 0) ? enemy.hp : 0;
    }

    public boolean isAlive() {
        return this.hp > 0 ? true : false;
    }
}
