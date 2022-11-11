package academy.pocu.comp2500.assignment3;

public class SmartMine extends Mine implements IThinkable {
    private static final char SYMBOL = 'A';
    private static final EUnitType UNIT_TYPE = EUnitType.UNDERGROUND;
    private static final int VISION = 1;
    private static final int AREA_OF_EFFECT = 1;
    private static final int AP = 15;
    private static final int HP = 1;
    private static final EUnitType[] ATTACK_TARGET_UNIT_TYPES = {
            EUnitType.GROUND
    };
    private static final EUnitType[] VISION_TARGET_UNIT_TYPES = {
            EUnitType.GROUND
    };

    public SmartMine(final IntVector2D position, final int bombRemainedbyStep,
                     final int bombRemainedByDetect) {
        super(position, bombRemainedbyStep);
        // constructor
    }

    @Override
    public void think() {

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
        SimulationManager.getInstance().registerThinkable(this);
        super.onSpawn();
    }
}
