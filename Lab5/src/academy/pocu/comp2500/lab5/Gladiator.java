package academy.pocu.comp2500.lab5;

import java.util.HashMap;

public class Gladiator extends Barbarian {
    protected HashMap<String, Move> moveMap;

    public Gladiator(String name, int hp, int attack, int defense) {
        super(name, hp, attack, defense);
        this.moveMap = new HashMap<>();
    }

    public boolean addMove(Move move) {
        if (this.moveMap.size() >= 4 || this.moveMap.containsKey(move.getName())) {
            return false;
        }
        this.moveMap.put(move.getName(), move);
        return true;
    }

    public boolean removeMove(String moveName) {
        if (!this.moveMap.containsKey(moveName)) {
            return false;
        }
        this.moveMap.remove(moveName);
        return true;
    }

    public void attack(String moveName, Barbarian enemy) {
        int movePower = 0;
        if (!this.isAlive() || !enemy.isAlive() || this.name == enemy.name || !moveMap.containsKey(moveName)) {
            return;
        }
        for (Move move : moveMap.values()) {
            if (move.getName().equals(moveName)) {
                if (move.getPp() == 0) {
                    return;
                } else {
                    movePower = move.getPower();
                    break;
                }
            }
        }
        double damageForCalc = ((double) this.attack / (double) enemy.defense * (double) movePower) / 2;
        int damage = (int) damageForCalc;
        enemy.hp = (damage > 1) ? enemy.hp - damage : enemy.hp - 1;
        enemy.hp = (enemy.hp > 0) ? enemy.hp : 0;
    }

    public void rest() {
        if (!this.isAlive()) {
            return;
        }
        addHp(10);
        for (Move move : moveMap.values()) {
            move.addPp(1);
        }
    }

    private void addHp(int hp) {
        this.hp = (this.hp + hp < this.maxHp) ? this.hp + hp : this.maxHp;
    }
}
