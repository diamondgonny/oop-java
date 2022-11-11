package academy.pocu.comp2500.assignment3;

public class Mine extends Unit implements IListener {
    private static final char SYMBOL = 'N';
    private static final EUnitType UNIT_TYPE = EUnitType.UNDERGROUND;
    private static final int VISION = 0;
    private static final int AREA_OF_EFFECT = 0;
    private static final int AP = 10;
    private static final int HP = 1;
    private static final EUnitType[] ATTACK_TARGET_UNIT_TYPES = {
            EUnitType.GROUND
    };
    private int bombRemainedCount;

    public Mine(final IntVector2D position, final int bombRemainedByStep) {
        // constructor
    }

    @Override
    public void listenCollisionEvent() {

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
        super.onSpawn();
    }
}
