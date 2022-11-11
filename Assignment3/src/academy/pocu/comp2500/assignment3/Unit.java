package academy.pocu.comp2500.assignment3;

public abstract class Unit {
    protected IntVector2D position;
    protected char symbol;
    protected int hp;

    protected EActionType actionType = EActionType.STANDBY;
    // protected AttackIntent attackIntent;

    public Unit(IntVector2D position, char symbol, int hp) {
        this.position = position;
        this.symbol = symbol;
        this.hp = hp;
    }

    public IntVector2D getPosition() {
        return position;
    }

    public char getSymbol() {
        return symbol;
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
    // 유닛이 월드에 추가될 때(spawn) SimulationManager가 이 메서드를 호출해야 합니다.
}
