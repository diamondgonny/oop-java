package academy.pocu.comp2500.lab5;

public class Knight extends Gladiator {
    private Pet pet;

    public Knight(String name, int hp, int attack, int defense) {
        super(name, hp, attack, defense);
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void attackTogether(Barbarian enemy) {
        if (pet == null) {
            return;
        }
        double damageForCalc = ((double)this.attack + (double)pet.getAttack() - (double)enemy.defense) / 2;
        int damage = (int)damageForCalc;
        enemy.hp = (damage > 1) ? enemy.hp - damage : enemy.hp - 1;
        enemy.hp = (enemy.hp > 0) ? enemy.hp : 0;
    }
}
