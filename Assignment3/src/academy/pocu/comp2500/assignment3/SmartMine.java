package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

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
    private int bombRemainedByDetect;

    public SmartMine(final IntVector2D position, final int bombRemainedbyStep,
                     final int bombRemainedByDetect) {
        super(position, SYMBOL, HP, UNIT_TYPE, bombRemainedbyStep);
        this.bombRemainedByDetect = bombRemainedByDetect;
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

    private boolean searchTargetForAttack() {
        // 만약 시야 안에서 몇 명 이상의 적 유닛이 감지되면, 스마트 지뢰가 폭발합니다.
        // out of bounds?
        int x = this.position.getX() - 1;
        int y = this.position.getY() - 1;
        for (int i = 0; i < 2 * VISION + 1; ++i) {
            for (int j = 0; j < 2 * VISION + 1; ++j) {
                ArrayList<Unit> candidates = simulationManager.getUnitsOnPosition(x + i, y + j);
                if (candidates.size() == 0) {
                    continue;
                }
                for (Unit candidate : candidates) {
                    if (candidate.getUnitType().equals(EUnitType.GROUND)) {
                        --bombRemainedByDetect;
                    }
                }
            }
        }
        bombRemainedByDetect = Math.max(bombRemainedByDetect, 0);
        return bombRemainedByDetect == 0;
    }
}
