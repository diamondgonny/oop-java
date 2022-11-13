package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public class SmartMine extends Mine implements IThinkable {
    private static final char SYMBOL = 'A';
    private static final EUnitType UNIT_TYPE = EUnitType.UNDERGROUND;
    private static final int VISION = 1;
    private static final int AREA_OF_EFFECT = 1;
    private static final int AP = 15;
    private static final int HP = 1;
    private static final EUnitType[] ATTACK_TARGET_UNIT_TYPES = {EUnitType.GROUND, EUnitType.UNDERGROUND};
    private static final EUnitType[] VISION_TARGET_UNIT_TYPES = {EUnitType.GROUND};
    private int smartMineThreshold;

    public SmartMine(final IntVector2D position, final int mineThreshold, final int smartMineThreshold) {
        super(position, SYMBOL, HP, UNIT_TYPE, mineThreshold);
        this.smartMineThreshold = smartMineThreshold;
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
        int minX = this.position.getX() - VISION;
        int minY = this.position.getY() - VISION;
        int maxX = minX + 2 * VISION;
        int maxY = minY + 2 * VISION;

        for (int y = minY; y <= maxY; ++y) {
            for (int x = minX; x <= maxX; ++x) {
                ArrayList<Unit> candidates = simulationManager.getUnitsOnPosition(x, y);
                if (candidates.size() == 0) {
                    continue;
                }
                for (Unit candidate : candidates) {
                    if (candidate.getUnitType().equals(EUnitType.GROUND)) {
                        --smartMineThreshold;
                    }
                }
            }
        }
        smartMineThreshold = Math.max(smartMineThreshold, 0);
        return smartMineThreshold == 0;
    }
}
