package academy.pocu.comp2500.assignment3;

public abstract class Unit {
    protected final SimulationManager simulationManager;
    protected IntVector2D position;
    protected char symbol;
    protected EUnitType unitType;
    protected int hp;

    protected EActionType actionType = EActionType.STANDBY;
    protected Unit targetOrNull;

    public Unit(IntVector2D position, char symbol, EUnitType unitType, int hp) {
        this.simulationManager = SimulationManager.getInstance();
        this.position = position;
        this.symbol = symbol;
        this.unitType = unitType;
        this.hp = hp;
    }

    public IntVector2D getPosition() {
        return position;
    }

    public char getSymbol() {
        return symbol;
    }

    public EUnitType getUnitType() {
        return unitType;
    }

    public int getHp() {
        return hp;
    }

    public AttackIntent attack() {
        // 공격 의도(AttackIntent) 개체를 반환합니다.
        // AttackIntent 안에는 공격 위치, 피해치, 공격자 등 공격에 필요한 정보가 담겨 있어야 합니다.
        return null;
    }

    public void onAttacked(int damage) {
        // 유닛에 피해치(damage)를 적용합니다.
    }

    public abstract void onSpawn();
}
