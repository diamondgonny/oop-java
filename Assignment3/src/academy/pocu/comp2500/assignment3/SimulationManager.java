package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public final class SimulationManager {
    private static SimulationManager instance;
    private static final int NUM_COLUMNS = 16;
    private static final int NUM_ROWS = 8;
    private final ArrayList<Unit> units = new ArrayList<>();
    private final ArrayList<IThinkable> thinkables = new ArrayList<>();
    private final ArrayList<IMovable> movables = new ArrayList<>();
    private final ArrayList<IListener> listeners = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<Unit>>> unitPositions;    // Review

    private SimulationManager() {
        this.unitPositions = new ArrayList<>();
        for (int i = 0; i < NUM_ROWS; ++i) {
            unitPositions.add(new ArrayList<>());
            for (int j = 0; j < NUM_COLUMNS; ++j) {
                unitPositions.get(i).add(new ArrayList<>());
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

    public ArrayList<Unit> getUnits() {
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
            unit.attack();
            // unit.onAttacked(damage);
        }
        for (Unit unit : this.units) {
            if (unit.getHp() == 0) {
                this.units.remove(unit);
                this.removeUnitPosition(unit);
                if (unit.getSymbol() != 'N' && unit.getSymbol() != 'A') {
                    this.thinkables.remove(unit);
                }
                if (unit.getSymbol() != 'N' && unit.getSymbol() != 'A' && unit.getSymbol() != 'U') {
                    this.movables.remove(unit);
                }
                if (unit.getSymbol() == 'N' && unit.getSymbol() != 'A') {
                    this.listeners.remove(unit);
                }
            }
        }
    }

    public ArrayList<Unit> getUnitsOnPosition(final int x, final int y) {
        return this.unitPositions.get(y).get(x);
    }

    public void addUnitPosition(final Unit unit, final int x, final int y) {
        this.unitPositions.get(y).get(x).add(unit);
    }

    public void addUnitPosition(final Unit unit) {
        int x = unit.getPosition().getX();
        int y = unit.getPosition().getY();
        this.addUnitPosition(unit, x, y);
    }

    public void removeUnitPosition(final Unit unit) {
        int x = unit.getPosition().getX();
        int y = unit.getPosition().getY();
        this.unitPositions.get(y).get(x).remove(unit);
    }

    public void moveUnitPosition(final Unit unit, final int moveX, final int moveY) {
        int x = unit.getPosition().getX();
        int y = unit.getPosition().getY();
        this.removeUnitPosition(unit);
        this.addUnitPosition(unit, x + moveX, y + moveY);
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

    // Out of bounds check?
}
