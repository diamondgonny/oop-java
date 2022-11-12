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
    private static final IntVector2D[] ATTACK_RANGE = {
            new IntVector2D(0, 0),
            new IntVector2D(0, -1),
            new IntVector2D(1, 0),
            new IntVector2D(0, 1),
            new IntVector2D(-1, 0)
    };

    public Marine(final IntVector2D position) {
        super(position, SYMBOL, HP);
        // constructor
    }

    @Override
    public void think() {
        if (searchPreyForAttack() != null) {
            actionType = EActionType.ATTACK;
        } else if (searchPreyForMove() != null) {
            actionType = EActionType.MOVE;
        } else {
            actionType = EActionType.STANDBY;
        }
    }

    @Override
    public void move() {
        // 1 가장 가까이 있는 유닛 쪽으로 이동. 가장 가까운 유닛은 맨해튼 거리를 사용하여 판단합니다.
        // 2 가장 약한 유닛 쪽으로 이동
        // 3 북쪽에 있는 유닛 쪽으로 이동, 북쪽에 유닛이 없다면 시계 방향으로 검색하다 찾은 유닛 쪽으로 이동
        // 이동할 때는 언제나 y축을 따라 다 이동한 뒤 x축을 따라 이동합니다.
        //
        // 해병이 시야 안에서 적을 찾지 못한 경우, 현재 타일에서 움직이지 않습니다.
    }

    @Override
    public AttackIntent attack() {
        // 1 가장 약한 유닛(HP가 가장 낮은 유닛)이 있는 타일을 공격
        // 2 자신의 위치에 유닛이 있다면 그 타일을 공격. 그렇지 않을 경우 북쪽(위쪽)에 유닛이 있다면 그 타일을 공격.
        //   그렇지 않을 경우 시계 방향으로 검색하다 찾은 유닛의 타일을 공격
        return null;
    }

    @Override
    public void onAttacked(int damage) {
        super.onAttacked(damage);
    }

    @Override
    public void onSpawn() {
        SimulationManager.getInstance().registerThinkable(this);
        SimulationManager.getInstance().registerMovable(this);
    }
}
