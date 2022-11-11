package academy.pocu.comp2500.assignment3;

public class Turret extends Unit implements IThinkable {
    private static final char SYMBOL = 'U';
    private static final EUnitType UNIT_TYPE = EUnitType.GROUND;
    private static final int VISION = 2;
    private static final int AREA_OF_EFFECT = 0;
    private static final int AP = 7;
    private static final int HP = 99;
    private static final EUnitType[] ATTACK_TARGET_UNIT_TYPES = {
            EUnitType.AIR
    };
    private static final EUnitType[] VISION_TARGET_UNIT_TYPES = {
            EUnitType.AIR
    };

    public Turret(final IntVector2D position) {
        // constructor
    }

    @Override
    public void think() {

    }

    @Override
    public AttackIntent attack() {
        return super.attack();
    }

    @Override
    public void onAttacked(int damage) {
        super.onAttacked(damage);
    }

    @Override
    public void onSpawn() {
        SimulationManager.getInstance().registerThinkable(this);
    }
}
