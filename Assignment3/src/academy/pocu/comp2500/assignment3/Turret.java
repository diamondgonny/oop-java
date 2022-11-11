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
        super(position, SYMBOL, HP);
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
    public AttackIntent attack() {
        // 다음은 미사일 포탑의 교전규칙입니다. (우선순위 순)
        // 1 가장 약한 유닛이 있는 타일을 공격
        // 2 자신의 위치에 유닛이 있다면 그 타일을 공격
        //  ㄴ 그렇지 않을 경우 북쪽(위쪽)에 유닛이 있다면 그 타일을 공격
        //  ㄴ 그렇지 않을 경우 시계 방향으로 검색하다 찾은 유닛의 타일을 공격
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
