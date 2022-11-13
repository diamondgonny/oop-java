package academy.pocu.comp2500.assignment3;

import java.util.LinkedHashSet;

public class Turret extends Unit implements IThinkable {
    private static final char SYMBOL = 'U';
    private static final EUnitType UNIT_TYPE = EUnitType.GROUND;
    private static final int VISION = 2;
    private static final int AREA_OF_EFFECT = 0;
    private static final int AP = 7;
    private static final int HP = 99;
    private static final EUnitType[] ATTACK_TARGET_UNIT_TYPES = {EUnitType.AIR};
    private static final EUnitType[] VISION_TARGET_UNIT_TYPES = {EUnitType.AIR};
    private static final IntVector2D[] ATTACK_RANGE = {
            new IntVector2D(0, 0),
            new IntVector2D(0, -1),
            new IntVector2D(1, -1),
            new IntVector2D(1, 0),
            new IntVector2D(1, 1),
            new IntVector2D(0, 1),
            new IntVector2D(-1, 1),
            new IntVector2D(-1, 0),
            new IntVector2D(-1, -1)
    };
    private Unit detectTargetOrNull;
    private IntVector2D attackPositionOrNull;

    public Turret(final IntVector2D position) {
        super(position, SYMBOL, UNIT_TYPE, HP);
        // constructor
    }

    @Override
    public void think() {
        if (searchTargetForAttack()) {
            actionType = EActionType.ATTACK;
        } else {
            actionType = EActionType.STANDBY;
        }
    }

    @Override
    public AttackIntent attack() {
        if (actionType != EActionType.ATTACK || attackPositionOrNull == null) {
            return new AttackIntent(this, simulationManager.invalidPositionGenerator());
        }
        AttackIntent attackIntent = new AttackIntent(this, attackPositionOrNull, AP,
                AREA_OF_EFFECT, ATTACK_TARGET_UNIT_TYPES, false);
        detectTargetOrNull = null;
        attackPositionOrNull = null;
        return attackIntent;
    }

    @Override
    public void onAttacked(int damage) {
        cutHp(damage);
    }

    @Override
    public void onSpawn() {
        SimulationManager.getInstance().registerThinkable(this);
    }

    @Override
    public void onRemove() {
        SimulationManager.getInstance().unregisterThinkable(this);
    }

    private boolean searchTargetForAttack() {
        for (IntVector2D attackRange : ATTACK_RANGE) {
            int x = this.position.getX() + attackRange.getX();
            int y = this.position.getY() + attackRange.getY();
            if (!simulationManager.isValidPosition(x, y)) {
                continue;
            }
            LinkedHashSet<Unit> candidates = simulationManager.getUnitsOnPosition(x, y);
            // 1 가장 약한 유닛이 있는 타일을 공격
            // 2 자신의 위치에 유닛이 있다면 그 타일을 공격
            //  ㄴ 그렇지 않을 경우 북쪽(위쪽)에 유닛이 있다면 그 타일을 공격
            //  ㄴ 그렇지 않을 경우 시계 방향으로 검색하다 찾은 유닛의 타일을 공격
            if (candidates.size() == 0) {
                continue;
            }
            for (Unit candidate : candidates) {
                if (!candidate.unitType.equals(EUnitType.AIR) || candidate == this) {
                    continue;
                }
                if (detectTargetOrNull == null || detectTargetOrNull.getHp() > candidate.getHp()) {
                    detectTargetOrNull = candidate;
                }
            }
        }
        if (detectTargetOrNull != null) {
            attackPositionOrNull = detectTargetOrNull.position;
            return true;
        }
        return false;
    }
}
