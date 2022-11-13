package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public final class SimulationManager {
    private static SimulationManager instance;
    private static final int NUM_COLUMNS = 8;
    private static final int NUM_ROWS = 16;
    private final ArrayList<IThinkable> thinkables = new ArrayList<>();
    private final ArrayList<IMovable> movables = new ArrayList<>();
    private final ArrayList<IListener> listeners = new ArrayList<>();
    private final ArrayList<Unit> units = new ArrayList<>();
    private final ArrayList<ArrayList<LinkedHashSet<Unit>>> unitPositions;
    private ArrayList<AttackIntent> attackIntents = new ArrayList<>();
    private final LinkedHashSet<Unit> attackedUnits = new LinkedHashSet<>();


    private SimulationManager() {
        this.unitPositions = new ArrayList<ArrayList<LinkedHashSet<Unit>>>();
        for (int y = 0; y < NUM_COLUMNS; ++y) {
            this.unitPositions.add(new ArrayList<LinkedHashSet<Unit>>());
            for (int x = 0; x < NUM_ROWS; ++x) {
                this.unitPositions.get(y).add(new LinkedHashSet<>());
            }
        }
    }

    public static SimulationManager getInstance() {
        if (instance == null) {
            instance = new SimulationManager();
        }
        return instance;
    }

    public int getNumRows() {
        return NUM_ROWS;
    }

    public int getNumColumns() {
        return NUM_COLUMNS;
    }

    public ArrayList<Unit> getUnits() {
        // SimulationManager.units 불러오기 vs 실시간으로 보드 덤프하기
        return units;
    }

    public void spawn(Unit unit) {
        this.units.add(unit);
        this.addUnitPosition(unit);
        unit.onSpawn(); // for register interfaces

    }

    public void registerThinkable(final IThinkable thinkable) {
        this.thinkables.add(thinkable);
    }

    public void registerMovable(final IMovable movable) {
        this.movables.add(movable);
    }

    public void registerCollisionEventListener(final IListener listener) {
        this.listeners.add(listener);
    }

    public void unregisterThinkable(final IThinkable thinkable) {
        this.thinkables.remove(thinkable);
    }

    public void unregisterMovable(final IMovable movable) {
        this.movables.remove(movable);
    }

    public void unregisterCollisionEventListener(final IListener listener) {
        this.listeners.remove(listener);
    }

    public void update() {
        // 1) 각 유닛들이 이번 프레임에서 할 행동(선택지: 공격, 이동, 아무것도 안 함)을 결정
        // 2) 움직일 수 있는 각 유닛에게 이동할 기회를 줌
        // 3) 이동 후 충돌 처리
        // 4) 각 유닛에게 공격할 기회를 줌
        // 5) 피해를 입어야 하는 각 유닛에게 피해를 입힘
        // 6) 죽은 유닛들을 모두 게임에서 제거함
        for (IThinkable thinkable : this.thinkables) {
            thinkable.think();
        }
        for (IMovable movable : this.movables) {
            movable.move();
        }
        for (IListener listener : this.listeners) {
            listener.listenCollisionEvent();
        }
        for (Unit unit : this.units) {
            AttackIntent attackIntent = unit.attack();
            if (attackIntent.isValid()) {
                attackIntents.add(attackIntent);
            }
        }
        for (final AttackIntent attackIntent : attackIntents) {
            attackIntent.strike(attackedUnits);
        }
        for (Unit unit : this.attackedUnits) {
            if (unit.getHp() == 0) {
                this.units.remove(unit);
                this.removeUnitPosition(unit);
                unit.onRemove(); // for unregister interfaces
            }
        }
        attackIntents.clear();
        attackedUnits.clear();
    }

    public LinkedHashSet<Unit> getUnitsOnPosition(final int x, final int y) {
        return this.unitPositions.get(y).get(x);
    }

    public boolean isValidPosition(final int x, final int y) {
        return 0 <= x && x < NUM_ROWS && 0 <= y && y < NUM_COLUMNS;
    }

    public void addUnitPosition(final Unit unit, final int x, final int y) {
        this.unitPositions.get(y).get(x).add(unit);
    }

    public void addUnitPosition(final Unit unit) {
        int x = unit.getPosition().getX();
        int y = unit.getPosition().getY();
        this.addUnitPosition(unit, x, y);
    }

    public void removeUnitPosition(final Unit unit, final int x, final int y) {
        this.unitPositions.get(y).get(x).remove(unit);
    }

    public void removeUnitPosition(final Unit unit) {
        int x = unit.getPosition().getX();
        int y = unit.getPosition().getY();
        this.unitPositions.get(y).get(x).remove(unit);
    }

    public void moveUnitPosition(final Unit unit, final int fromX, final int fromY,
                                 final int toX, final int toY) {
        this.removeUnitPosition(unit, fromX, fromY);
        this.addUnitPosition(unit, toX, toY);
    }

    public boolean compareClockwiseOrder(IntVector2D origin, IntVector2D target, IntVector2D candidate) {
        double x1 = target.getX() - origin.getX();
        double y1 = target.getY() - origin.getY();
        double x2 = candidate.getX() - origin.getX();
        double y2 = candidate.getY() - origin.getY();
        double angleTarget = (Math.atan2(y1, x1) - Math.atan2(-1, 0)) * (180.0 / Math.PI);
        double angleCandidate = (Math.atan2(y2, x2) - Math.atan2(-1, 0)) * (180.0 / Math.PI);
        if (angleTarget < 0) {
            angleTarget += 360;
        }
        if (angleCandidate < 0) {
            angleCandidate += 360;
        }
        return angleTarget > angleCandidate;
    }

    public IntVector2D invalidPositionGenerator() {
        IntVector2D ghost = new IntVector2D(Integer.MIN_VALUE, Integer.MIN_VALUE);
        return ghost;
    }
}
