package academy.pocu.comp2500.assignment3;

public class Tank extends Unit implements IThinkable, IMovable {
    private static final char SYMBOL = 'T';
    private static final EUnitType UNIT_TYPE = EUnitType.GROUND;
    private static final int VISION = 3;
    private static final int AREA_OF_EFFECT = 1;
    private static final int AP = 8;
    private static final int HP = 85;
    private static final EUnitType[] ATTACK_TARGET_UNIT_TYPES = {
            EUnitType.GROUND
    };
    private static final EUnitType[] VISION_TARGET_UNIT_TYPES = {
            EUnitType.GROUND
    };

    public Tank(final IntVector2D position) {
        super(position, SYMBOL, HP);
        // constructor
    }

    @Override
    public void think() {
        if (searchPreyForAttack() != null) {
            actionType = EActionType.ATTACK;
        } else {
            actionType = EActionType.MOVE;
        }
    }

    @Override
    public void move() {
        // 전차가 시야 안에서 적을 찾지 못하면, 다음의 이동 규칙을 따릅니다. (역시 우선순위 순)
        // 1 이동하던 방향 끝까지 이동. 한번도 이동한 적이 없다면 오른쪽으로 이동
        // 2 반대 방향 끝까지 이동
        // 3 시야 안에서 적을 발견할 때까지 1 - 2를 반복
    }

    @Override
    public AttackIntent attack() {
        // 전차가 시야 안에서 적을 찾으면, 공성 모드(1 프레임 소모)로 변환하여 공격할 준비를 합니다.
        // 1 현재 공성 모드가 아닌 경우 공성 모드로 변경
        // 2 가장 약한 유닛이 있는 타일을 공격
        // 3 북쪽에 유닛이 있다면 그 타일을 공격. 그렇지 않을 경우 시계 방향으로 검색하다가 찾은 유닛의 타일을 공격
        return super.attack();
    }

    @Override
    public void onAttacked(int damage) {
        // 공성모드일 때 2배 피해 받음
        super.onAttacked(damage);
    }

    @Override
    public void onSpawn() {
        SimulationManager.getInstance().registerThinkable(this);
        SimulationManager.getInstance().registerMovable(this);
    }
}
