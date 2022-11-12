package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public class UnitPositionManager {
    private static UnitPositionManager instance;
    private static final int NUM_COLUMNS = 16;
    private static final int NUM_ROWS = 8;
    private ArrayList<ArrayList<ArrayList<Unit>>> unitPositions;    // Review

    private UnitPositionManager() {
        this.unitPositions = new ArrayList<>();
        for (int i = 0; i < NUM_ROWS; ++i) {
            unitPositions.add(new ArrayList<>());
            for (int j = 0; j < NUM_COLUMNS; ++j) {
                unitPositions.get(i).add(new ArrayList<>());
            }
        }
    }

    public static void createInstance() {
        assert (instance == null) : "do not create instance twice...";
        instance = new UnitPositionManager();
    }
    /*
    public static void deleteInstance() {
        assert (instance != null) : "no instance to delete...";
        instance = null;
    }
    */
    public static UnitPositionManager getInstance() {
        assert (instance != null) : "no instance was created before get()";
        return instance;
    }

    public ArrayList<Unit> getUnitsOnPosition(final int x, final int y) {
        return this.unitPositions.get(y).get(x);
    }

    public void add(final Unit unit, final int x, final int y) {
        this.unitPositions.get(y).get(x).add(unit);
    }

    public void add(final Unit unit) {
        int x = unit.getPosition().getX();
        int y = unit.getPosition().getY();
        this.add(unit, x, y);
    }

    public void remove(final Unit unit) {
        int x = unit.getPosition().getX();
        int y = unit.getPosition().getY();
        this.unitPositions.get(y).get(x).remove(unit);
    }

    public void move(final Unit unit, final int moveX, final int moveY) {
        int x = unit.getPosition().getX();
        int y = unit.getPosition().getY();
        this.remove(unit);
        this.add(unit, x + moveX, y + moveY);
    }

    // Out of bounds check?

}
