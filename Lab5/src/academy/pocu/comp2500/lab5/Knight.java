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
        double damage = (this.attack + pet.getAttack() * enemy.defense) / 2;
        if (damage >= 2) {
            enemy.hp -= (int) damage;
        } else {
            enemy.hp -= 1;
        }
    }
}
