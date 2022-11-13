package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Mine extends Unit implements IListener {
    private static final char SYMBOL = 'N';
    private static final EUnitType UNIT_TYPE = EUnitType.UNDERGROUND;
    private static final int VISION = 0;
    private static final int AREA_OF_EFFECT = 0;
    private static final int AP = 10;
    private static final int HP = 1;
    private static final EUnitType[] ATTACK_TARGET_UNIT_TYPES = {EUnitType.GROUND, EUnitType.UNDERGROUND};
    // (지뢰는 움직일 수 없는 유닛이며, 다른 유닛은 지뢰를 볼 수 없습니다.)
    protected int mineThreshold;
    // 다른 유닛이 일정 횟수만큼 밟으면 그때 터집니다. 지뢰 위치에 있는 다른 유닛들은 모두 피해를 입습니다.
    // ㄴ 이 횟수는 지뢰마다 다르게 지정할 수 있습니다. ㄴ 터진 지뢰는 파괴됩니다.

    public Mine(final IntVector2D position, final int mineThreshold) {
        super(position, SYMBOL, UNIT_TYPE, HP);
        this.mineThreshold = mineThreshold;
        // constructor
    }

    protected Mine(final IntVector2D position, final char symbol, final int hp,
                   final EUnitType unitType, final int mineThreshold) {
        super(position, symbol, unitType, hp);
        this.mineThreshold = mineThreshold;
        // constructor
    }

    @Override
    public void listenCollisionEvent() {
        int x = this.position.getX();
        int y = this.position.getY();
        ArrayList<Unit> candidates = simulationManager.getUnitsOnPosition(x, y);

        if (candidates.size() == 0) {
            return;
        }
        for (Unit candidate : candidates) {
            if (!candidate.getUnitType().equals(EUnitType.AIR) && candidate != this) {
                --mineThreshold;
            }
        }
        mineThreshold = Math.max(mineThreshold, 0);
    }

    @Override
    public AttackIntent attack() {
        if (mineThreshold != 0) {
            return new AttackIntent(this, simulationManager.invalidPositionGenerator());
        }
        return new AttackIntent(this, this.position, AP,
                AREA_OF_EFFECT, ATTACK_TARGET_UNIT_TYPES, true);
    }

    @Override
    public void onAttacked(int damage) {
        cutHp(damage);
    }

    @Override
    public void onSpawn() {
        SimulationManager.getInstance().registerCollisionEventListener(this);
    }

    @Override
    public void onRemove() {
        SimulationManager.getInstance().unregisterCollisionEventListener(this);
    }
}
