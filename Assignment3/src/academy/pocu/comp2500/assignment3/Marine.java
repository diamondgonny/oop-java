package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public class Marine extends Unit implements IThinkable, IMovable {
    private static final char SYMBOL = 'M';
    private static final EUnitType UNIT_TYPE = EUnitType.GROUND;
    private static final int VISION = 2;
    private static final int AREA_OF_EFFECT = 0;
    private static final int AP = 6;
    private static final int HP = 35;
    private static final EUnitType[] ATTACK_TARGET_UNIT_TYPES = {EUnitType.GROUND, EUnitType.AIR};
    private static final EUnitType[] VISION_TARGET_UNIT_TYPES = {EUnitType.GROUND, EUnitType.AIR};
    private static final IntVector2D[] ATTACK_RANGE = {
            new IntVector2D(0, 0),
            new IntVector2D(0, -1),
            new IntVector2D(1, 0),
            new IntVector2D(0, 1),
            new IntVector2D(-1, 0)
    };
    private Unit detectTargetOrNull;
    private IntVector2D attackPointOrNull;

    public Marine(final IntVector2D position) {
        super(position, SYMBOL, UNIT_TYPE, HP);
        // constructor
    }

    @Override
    public void think() {
        if (searchTargetForAttack()) {
            actionType = EActionType.ATTACK;
        } else if (searchTargetForMove()) {
            actionType = EActionType.MOVE;
        } else {
            actionType = EActionType.STANDBY;
        }
    }

    @Override
    public void move() {
        int targetX = detectTargetOrNull.position.getX();
        int targetY = detectTargetOrNull.position.getY();
        int thisX = this.position.getX();
        int thisY = this.position.getY();

        if (actionType != EActionType.MOVE) {
            return;
        }
        if (targetY < thisY) {
            this.position.setY(this.position.getY() - 1);
        } else if (targetY > thisY) {
            this.position.setY(this.position.getY() + 1);
        } else {
            if (targetX < thisX) {
                this.position.setX(this.position.getX() - 1);
            } else if (targetX > thisX) {
                this.position.setX(this.position.getX() + 1);
            }
            // move()에서 위치가 동일할 일은 없음
        }
        detectTargetOrNull = null;
    }

    @Override
    public AttackIntent attack() {
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

    private boolean searchTargetForMove() {
        // 1 가장 가까이 있는 유닛 쪽으로 이동. 가장 가까운 유닛은 맨해튼 거리를 사용하여 판단합니다.
        // 2 가장 약한 유닛 쪽으로 이동
        // 3 북쪽에 있는 유닛 쪽으로 이동, 북쪽에 유닛이 없다면 시계 방향으로 검색하다 찾은 유닛 쪽으로 이동
        int thisX = this.position.getX();
        int thisY = this.position.getY();

        for (Unit candidate : simulationManager.getUnits()) {
            int candidateX = candidate.position.getX();
            int candidateY = candidate.position.getY();

            // 무효한 후보유닛인가?
            if (!candidate.getUnitType().equals(EUnitType.AIR) &&
                    !candidate.getUnitType().equals(EUnitType.GROUND) || candidate == this) {
                continue;
            }
            // 시야 안에 없는가?
            if ((Math.max(Math.abs(thisX - candidateX), Math.abs(thisY - candidateY))) > VISION) {
                continue;
            }
            // 타겟이 비었는가?
            if (detectTargetOrNull == null) {
                detectTargetOrNull = candidate;
                continue;
            }
            int targetX = detectTargetOrNull.position.getX();
            int targetY = detectTargetOrNull.position.getY();
            int candidateDistance = Math.abs(thisX - candidateX) + Math.abs(thisY - candidateY);
            int targetDistance = Math.abs(thisX - targetX) + Math.abs(thisY - targetY);

            // 1 후보유닛이 더 먼가? ㅂㅇ
            if (targetDistance < candidateDistance) {
                continue;
            }
            // 1 더 가까운가? 2 더 약한가? 3 시계방향?
            if (targetDistance > candidateDistance || detectTargetOrNull.getHp() > candidate.getHp() ||
                    simulationManager.compareClockwiseOrder(this.position, detectTargetOrNull.position, candidate.position)) {
                detectTargetOrNull = candidate;
            }
        }
        return detectTargetOrNull != null;
    }

    private boolean searchTargetForAttack() {
        for (IntVector2D attackRange : ATTACK_RANGE) {
            int x = this.position.getX() + attackRange.getX();
            int y = this.position.getY() + attackRange.getY();
            ArrayList<Unit> candidates = simulationManager.getUnitsOnPosition(x, y);

            // 1 가장 약한 유닛이 있는 타일을 공격
            // 2 자신의 위치에 유닛이 있다면 그 타일을 공격
            //  ㄴ 그렇지 않을 경우 북쪽(위쪽)에 유닛이 있다면 그 타일을 공격
            //  ㄴ 그렇지 않을 경우 시계 방향으로 검색하다 찾은 유닛의 타일을 공격
            if (candidates.size() == 0) {
                continue;
            }
            for (Unit candidate : candidates) {
                if (!candidate.getUnitType().equals(EUnitType.AIR) &&
                        !candidate.getUnitType().equals(EUnitType.GROUND) || candidate == this) {
                    continue;
                }
                if (detectTargetOrNull == null || detectTargetOrNull.getHp() > candidate.getHp()) {
                    detectTargetOrNull = candidate;
                }
            }
        }
        if (detectTargetOrNull != null) {
            attackPointOrNull = detectTargetOrNull.position;
            return true;
        }
        return false;
    }
}
