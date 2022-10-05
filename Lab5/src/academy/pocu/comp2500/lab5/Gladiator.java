package academy.pocu.comp2500.lab5;

import java.util.HashSet;

public class Gladiator extends Barbarian {
    private HashSet<Move> moveSet;

    public Gladiator(String name, int hp, int attack, int defense) {
        super(name, hp, attack, defense);
        this.moveSet = new HashSet<>();
    }

    public boolean addMove(Move move) {
        if (this.moveSet.size() >= 4) {
            return false;
        }
        return this.moveSet.add(move) ? true : false;
    }

    public boolean removeMove(String moveName) {
        return this.moveSet.remove(moveName) ? true : false;
    }

    public void attack(String moveName, Barbarian enemy) {
        int movePower = 0;
        if (!this.isAlive() || !enemy.isAlive() || this.name == enemy.name) {
            return;
        }
        // 지정된 공격스킬을 사용하여 적을 공격하는데, 그 스킬을 모를경우 공격실패
        if (!moveSet.contains(moveName)) {
            return;
        }
        // 남아있는 파워 수치가 불충분하면 공격실패
        for (Move move : moveSet) {
            if (move.equals(moveName)) {
                if (move.getPower() == 0) {
                    return;
                } else {
                    movePower = move.getPower();
                    break;
                }
            }
        }
        double damage = (this.attack / enemy.defense * movePower) / 2;
        if (damage >= 2) {
            enemy.hp -= (int) damage;
        } else {
            enemy.hp -= 1;
        }
    }

    public void rest() {
        if (!this.isAlive()) {
            return;
        }
        addHp(10);
        for (Move move : moveSet) {
            move.addPower(1);
        }
    }

    public void addHp(int hp) {
        if (this.hp + hp < this.maxHp) {
            this.hp += hp;
        } else {
            this.hp = this.maxHp;
        }
    }

}
