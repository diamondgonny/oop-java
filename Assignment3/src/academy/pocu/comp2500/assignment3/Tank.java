package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

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
    private boolean siegeMode = false;

    public Tank(final IntVector2D position) {
        super(position, SYMBOL, UNIT_TYPE, HP);
        // constructor
    }

    @Override
    public void think() {
        if (scanTarget()) {
            searchTargetForAttack();
            actionType = EActionType.ATTACK;
        } else {
            actionType = EActionType.MOVE;
        }
    }

    @Override
    public void move() {
        // 2) 전차가 시야 안에서 적을 찾지 못하면, 다음의 이동 규칙을 따릅니다. (역시 우선순위 순)
        // 1 이동하던 방향 끝까지 이동. 한번도 이동한 적이 없다면 오른쪽으로 이동
        // 2 반대 방향 끝까지 이동
        // (시야 안에서 적을 발견할 때까지 1 - 2를 반복)
    }

    @Override
    public AttackIntent attack() {
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

    private boolean scanTarget() {
        // 1) 전차가 시야 안에서 적을 찾았는가?
        // 탱크모드 : 공성 모드(1 프레임 소모)로 변경하여 공격할 준비 (끝) -> attack
        // 공성모드 : 다음 단계로... -> attack
        // out of bounds?
        int x = this.position.getX() - VISION;
        int y = this.position.getY() - VISION;
        for (int i = 0; i < 2 * VISION + 1; ++i) {
            for (int j = 0; j < 2 * VISION + 1; ++j) {
                ArrayList<Unit> candidates = simulationManager.getUnitsOnPosition(x + i, y + j);
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
            ArrayList<Unit> candidates = simulationManager.getUnitsOnPosition(x, y);
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
                if (targetOrNull == null || targetOrNull.getHp() > candidate.getHp()) {
                    targetOrNull = candidate;
                }
            }
        }
        return targetOrNull != null;
    }
}
