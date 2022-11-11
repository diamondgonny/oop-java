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
    private int bombRemainedbyDetect;

    public SmartMine(final IntVector2D position, final int bombRemainedbyStep,
                     final int bombRemainedByDetect) {
        super(position, SYMBOL, HP, bombRemainedbyStep);
        this.bombRemainedbyDetect = bombRemainedbyDetect;
        // constructor
    }

    @Override
    public void think() {
        if (searchPreyForAttack() != null) {
            actionType = EActionType.ATTACK;
        } else {
            actionType = EActionType.STANDBY;
        }
    }

    @Override
    public void listenCollisionEvent() {

    }

    @Override
    public AttackIntent attack() {
        // 만약 시야 안에서 몇 명 이상의 적 유닛이 감지되면, 스마트 지뢰가 폭발합니다.
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
