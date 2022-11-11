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
    // (지뢰는 움직일 수 없는 유닛이며, 다른 유닛은 지뢰를 볼 수 없습니다.)
    protected int bombRemainedByStep;
    // 다른 유닛이 일정 횟수만큼 밟으면 그때 터집니다. 지뢰 위치에 있는 다른 유닛들은 모두 피해를 입습니다.
    // ㄴ 이 횟수는 지뢰마다 다르게 지정할 수 있습니다. ㄴ 터진 지뢰는 파괴됩니다.

    public Mine(final IntVector2D position, final int bombRemainedByStep) {
        super(position, SYMBOL, HP);
        this.bombRemainedByStep = bombRemainedByStep;
        // constructor
    }

    protected Mine(final IntVector2D position, final char symbol, final int hp,
                   final int bombRemainedByStep) {
        super(position, symbol, hp);
        this.bombRemainedByStep = bombRemainedByStep;
        // constructor
    }

    @Override
    public void listenCollisionEvent() {
        (위 참조)
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
        SimulationManager.getInstance().registerCollisionEventListener(this);
    }
}
