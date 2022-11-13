package academy.pocu.comp2500.assignment3;

public class Destroyer extends Unit {
    private static final char SYMBOL = 'D';
    private static final EUnitType UNIT_TYPE = EUnitType.AIR;
    private static final int VISION = 9999;
    private static final int AREA_OF_EFFECT = 9999;
    private static final int AP = 9999;
    private static final int HP = 9999;
    private static final EUnitType[] ATTACK_TARGET_UNIT_TYPES = {EUnitType.GROUND, EUnitType.AIR};
    private static final EUnitType[] VISION_TARGET_UNIT_TYPES = {EUnitType.GROUND, EUnitType.AIR};

    public Destroyer(IntVector2D position) {
        super(position, SYMBOL, UNIT_TYPE, HP);
        //constructor
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
        // ???
    }

    @Override
    public void onRemove() {
        // ???
    }
}
