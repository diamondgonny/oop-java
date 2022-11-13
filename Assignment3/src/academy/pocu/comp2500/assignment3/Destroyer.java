package academy.pocu.comp2500.assignment3;

public class Destroyer extends Unit {
    private static final char SYMBOL = 'D';
    private static final EUnitType UNIT_TYPE = EUnitType.AIR;
    private static final int VISION = Integer.MAX_VALUE;
    private static final int AREA_OF_EFFECT = Integer.MAX_VALUE;
    private static final int AP = Integer.MAX_VALUE;
    private static final int HP = Integer.MAX_VALUE;
    private static final EUnitType[] ATTACK_TARGET_UNIT_TYPES = {EUnitType.GROUND, EUnitType.AIR, EUnitType.UNDERGROUND};
    private static final EUnitType[] VISION_TARGET_UNIT_TYPES = {EUnitType.GROUND, EUnitType.AIR, EUnitType.UNDERGROUND};

    public Destroyer(IntVector2D position) {
        super(position, SYMBOL, UNIT_TYPE, HP);
        //constructor
    }

    @Override
    public AttackIntent attack() {
        return new AttackIntent(this, new IntVector2D(0, 0), AP, AREA_OF_EFFECT,
                ATTACK_TARGET_UNIT_TYPES, false);
    }

    @Override
    public void onAttacked(int damage) {
        cutHp(-1);
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
