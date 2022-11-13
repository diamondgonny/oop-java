package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Wraith extends Unit implements IThinkable, IMovable {
    private static final char SYMBOL = 'W';
    private static final EUnitType UNIT_TYPE = EUnitType.AIR;
    private static final int VISION = 4;
    private static final int AREA_OF_EFFECT = 0;
    private static final int AP = 6;
    private static final int HP = 80;
    private static final EUnitType[] ATTACK_TARGET_UNIT_TYPES = {EUnitType.GROUND, EUnitType.AIR};
    private static final EUnitType[] VISION_TARGET_UNIT_TYPES = {EUnitType.GROUND, EUnitType.AIR};
    private static final IntVector2D[] ATTACK_RANGE = {
            new IntVector2D(0, 0),
            new IntVector2D(0, -1),
            new IntVector2D(1, 0),
            new IntVector2D(0, 1),
            new IntVector2D(-1, 0)
    };
    private final IntVector2D initialPosition;
    private Unit detectTargetOrNull;
    private IntVector2D attackPositionOrNull;
    private boolean unusedShield = true;
    private boolean activateShield = false;
    // 망령은 공격을 받으면 즉시 가동되는 특수 방어막을 가지고 있습니다.
    // 한 번 가동된 방어막은 현재 프레임이 끝날 때까지 지속되어 망령은 피해를 입지 않습니다.
    // 다음 프레임부터는 공격을 받으면 피해를 입습니다.

    public Wraith(final IntVector2D position) {
        super(position, SYMBOL, UNIT_TYPE, HP);
        this.initialPosition = position;
        // constructor
    }

    @Override
    public void think() {
        if (activateShield) {
            unusedShield = false;
            activateShield = false;
        }
        if (searchTargetForAttack(EUnitType.AIR) || searchTargetForAttack(EUnitType.GROUND)) {
            actionType = EActionType.ATTACK;
        }
        if (!searchTargetForMove(EUnitType.AIR)) {
            searchTargetForMove(EUnitType.GROUND);
        }
        actionType = EActionType.MOVE;
    }

    @Override
    public void move() {
        int targetX;
        int targetY;
        int thisX = this.position.getX();
        int thisY = this.position.getY();

        if (actionType != EActionType.MOVE) {
            return;
        }
        if (detectTargetOrNull != null) {
            targetX = detectTargetOrNull.position.getX();
            targetY = detectTargetOrNull.position.getY();
        } else {
            targetX = initialPosition.getX();
            targetY = initialPosition.getY();
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
        if (unusedShield) {
            activateShield = true;
            return;
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

    private boolean searchTargetForMove(EUnitType visionTargetUnitType) {
        // 1) 다음은 망령이 시야 안에서 적을 발견할 경우, 따르는 이동 규칙입니다. (역시 우선순위 순)
        // 1 공중 유닛들을 따라갈 후보로 선택. 선택할 공중 유닛이 없다면 지상 유닛들을 선택
        // 2 가장 가까이 있는 유닛 쪽으로 이동
        // 3 가장 약한 유닛 쪽으로 이동
        // 4 북쪽에 있는 유닛 쪽으로 이동. 북쪽에 유닛이 없다면 시계 방향으로 검색하다 찾은 유닛 쪽으로 이동
        int thisX = this.position.getX();
        int thisY = this.position.getY();

        for (Unit candidate : simulationManager.getUnits()) {
            int candidateX = candidate.position.getX();
            int candidateY = candidate.position.getY();

            // 무효한 후보유닛인가?
            if (!candidate.getUnitType().equals(visionTargetUnitType) || candidate == this) {
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

    private boolean searchTargetForAttack(EUnitType attackTargetUnitType) {
        // ***공중 유닛들을 공격할 후보로 선택. 선택할 공중 유닛이 없다면 지상 유닛들을 선택
        for (IntVector2D attackRange : ATTACK_RANGE) {
            int x = this.position.getX() + attackRange.getX();
            int y = this.position.getY() + attackRange.getY();
            if (!simulationManager.isValidPosition(x, y)) {
                continue;
            }
            ArrayList<Unit> candidates = simulationManager.getUnitsOnPosition(x, y);

            // 1 가장 약한 유닛이 있는 타일을 공격
            // 2 자신의 위치에 유닛이 있다면 그 타일을 공격
            //  ㄴ 그렇지 않을 경우 북쪽(위쪽)에 유닛이 있다면 그 타일을 공격
            //  ㄴ 그렇지 않을 경우 시계 방향으로 검색하다 찾은 유닛의 타일을 공격
            if (candidates.size() == 0) {
                continue;
            }
            for (Unit candidate : candidates) {
                if (!candidate.getUnitType().equals(attackTargetUnitType) || candidate == this) {
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
