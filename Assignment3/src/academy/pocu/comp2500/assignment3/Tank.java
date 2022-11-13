package academy.pocu.comp2500.assignment3;

import java.util.LinkedHashSet;

public class Tank extends Unit implements IThinkable, IMovable {
    private static final char SYMBOL = 'T';
    private static final EUnitType UNIT_TYPE = EUnitType.GROUND;
    private static final int VISION = 3;
    private static final int AREA_OF_EFFECT = 1;
    private static final int AP = 8;
    private static final int HP = 85;
    private static final EUnitType[] ATTACK_TARGET_UNIT_TYPES = {EUnitType.GROUND};
    private static final EUnitType[] VISION_TARGET_UNIT_TYPES = {EUnitType.GROUND};
    private static final IntVector2D[] ATTACK_RANGE = {
            new IntVector2D(0, -2),
            new IntVector2D(1, -2),
            new IntVector2D(2, -1),
            new IntVector2D(2, 0),
            new IntVector2D(2, 1),
            new IntVector2D(1, 2),
            new IntVector2D(0, 2),
            new IntVector2D(-1, 2),
            new IntVector2D(-2, 1),
            new IntVector2D(-2, 0),
            new IntVector2D(-2, -1),
            new IntVector2D(-1, -2)
    };
    private Unit detectTargetOrNull;
    private IntVector2D attackPositionOrNull;
    private boolean siegeMode = false;
    private boolean patrolRightDirection = true;

    public Tank(final IntVector2D position) {
        super(position, SYMBOL, UNIT_TYPE, HP);
        // constructor
    }

    @Override
    public void think() {
        if (!this.siegeMode) {
            // 탱크모드
            if (scanTarget()) {
                this.siegeMode = true;
                actionType = EActionType.STANDBY;
            } else {
                actionType = EActionType.MOVE;
            }
        } else {
            // 공성모드
            if (searchTargetForAttack()) {
                actionType = EActionType.ATTACK;
            } else {
                actionType = EActionType.STANDBY;
            }
        }
    }

    @Override
    public void move() {
        // 2) 전차가 시야 안에서 적을 찾지 못하면, 다음의 이동 규칙을 따릅니다. (역시 우선순위 순)
        // 1 이동하던 방향 끝까지 이동. 한번도 이동한 적이 없다면 오른쪽으로 이동
        // 2 반대 방향 끝까지 이동
        // (시야 안에서 적을 발견할 때까지 1 - 2를 반복)
        if (actionType != EActionType.MOVE) {
            return;
        }
        if (patrolRightDirection == true) {
            if (this.position.getX() == simulationManager.getNumRows() - 1) {
                patrolRightDirection = false;
                this.position.setX(this.position.getX() - 1);
            } else {
                this.position.setX(this.position.getX() + 1);
            }
        } else {
            if (this.position.getX() == 0) {
                patrolRightDirection = true;
                this.position.setX(this.position.getX() + 1);
            } else {
                this.position.setX(this.position.getX() - 1);
            }
        }
        detectTargetOrNull = null;
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
        if (siegeMode) {
            damage *= 2;
        }
        cutHp(damage);
    }

    @Override
    public void onSpawn() {
        SimulationManager.getInstance().registerThinkable(this);
        SimulationManager.getInstance().registerMovable(this);
    }

    @Override
    public void onRemove() {
        SimulationManager.getInstance().unregisterThinkable(this);
        SimulationManager.getInstance().unregisterMovable(this);
    }

    private boolean scanTarget() {
        int minX = this.position.getX() - VISION;
        int minY = this.position.getY() - VISION;
        int maxX = minX + 2 * VISION;
        int maxY = minY + 2 * VISION;

        for (int y = minY; y <= maxY; ++y) {
            for (int x = minX; x <= maxX; ++x) {
                if (!simulationManager.isValidPosition(x, y)) {
                    continue;
                }
                LinkedHashSet<Unit> candidates = simulationManager.getUnitsOnPosition(x, y);
                for (Unit candidate : candidates) {
                    if (!(!candidate.getUnitType().equals(EUnitType.GROUND) || candidate == this)) {
                        // 시야 안에서 적 발견됨
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean searchTargetForAttack() {
        for (IntVector2D attackRange : ATTACK_RANGE) {
            int x = this.position.getX() + attackRange.getX();
            int y = this.position.getY() + attackRange.getY();
            if (!simulationManager.isValidPosition(x, y)) {
                continue;
            }
            LinkedHashSet<Unit> candidates = simulationManager.getUnitsOnPosition(x, y);

            // 다음은 전차의 교전규칙입니다. (우선순위 순)
            // 1-1 현재 공성 모드가 아닌 경우 공성 모드로 변경************************
            // 2-1 가장 약한 유닛이 있는 타일을 공격
            // 2-2 북쪽에 유닛이 있다면 그 타일을 공격. 그렇지 않을 경우 시계 방향으로 검색하다가 찾은 유닛의 타일을 공격
            if (candidates.size() == 0) {
                continue;
            }
            for (Unit candidate : candidates) {
                if (!candidate.unitType.equals(EUnitType.GROUND)) {
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
