package academy.pocu.comp2500.lab5;

public class Barbarian {
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
        if (!this.isAlive() || !enemy.isAlive() || this.name == enemy.name) {
            return;
        }

        double damage = (this.attack - enemy.defense) / 2;
        if (damage >= 2) {
            enemy.hp -= (int) damage;
        } else {
            enemy.hp -= 1;
        }
    }

    public boolean isAlive() {
        return this.hp > 0 ? true : false;
    }
}
