package academy.pocu.comp2500.assignment3;

public class Marine extends Unit implements IThinkable, IMovable {
    private static final char SYMBOL = 'M';
    private static final EUnitType UNIT_TYPE = EUnitType.GROUND;
    private static final int VISION = 2;
    private static final int AREA_OF_EFFECT = 0;
    private static final int AP = 6;
    private static final int HP = 35;
    private static final EUnitType[] ATTACK_TARGET_UNIT_TYPES = {
            EUnitType.GROUND,
            EUnitType.AIR
    };
    private static final EUnitType[] VISION_TARGET_UNIT_TYPES = {
            EUnitType.GROUND,
            EUnitType.AIR
    };

    public Marine(final IntVector2D position) {
       // constructor
    }

    @Override
    public void think() {

    }

    @Override
    public void move() {

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
