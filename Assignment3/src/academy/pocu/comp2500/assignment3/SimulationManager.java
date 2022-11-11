package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public final class SimulationManager {
    private static SimulationManager instance;
    private final ArrayList<Unit> units;
    private final ArrayList<IThinkable> thinkables;
    private final ArrayList<IMovable> movables;
    private final ArrayList<IListener> listeners;

    private SimulationManager() {
        this.units = new ArrayList<>();
        this.thinkables = new ArrayList<>();
        this.movables = new ArrayList<>();
        this.listeners = new ArrayList<>();
    }

    public static SimulationManager getInstance() {
        if (instance == null) {
            instance = new SimulationManager();
        }
        return instance;
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public void spawn(Unit unit) {
        this.units.add(unit);
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
    }
}
