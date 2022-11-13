package academy.pocu.comp2500.assignment3;

import java.util.LinkedHashSet;

public class AttackIntent {
    private final SimulationManager simulationManager;
    private final Unit attacker;
    private final IntVector2D attackPosition;
    private final int ap;
    private final int areaOfEffect;
    private final EUnitType[] canAttackUnitTypes;
    private final boolean canSelfAttack;

    public AttackIntent(Unit attacker, IntVector2D attackPosition) {
        this(attacker, attackPosition, 0, 0, new EUnitType[]{}, false);
    }

    public AttackIntent(Unit attacker, IntVector2D attackPosition, int ap, int areaOfEffect,
                        EUnitType[] canAttackUnitTypes, boolean canSelfAttack) {
        this.simulationManager = SimulationManager.getInstance();
        this.attacker = attacker;
        this.attackPosition = attackPosition;
        this.ap = ap;
        this.areaOfEffect = areaOfEffect;
        this.canAttackUnitTypes = canAttackUnitTypes;
        this.canSelfAttack = canSelfAttack;
    }

    public boolean isValid() {
        return simulationManager.isValidPosition(this.attackPosition.getX(),
                this.attackPosition.getY());
    }

    public void strike(LinkedHashSet<Unit> attackedUnits) {
        final int minY = this.attackPosition.getY() - this.areaOfEffect;
        final int minX = this.attackPosition.getX() - this.areaOfEffect;
        final int maxY = this.attackPosition.getY() + this.areaOfEffect;
        final int maxX = this.attackPosition.getX() + this.areaOfEffect;
        System.out.println(String.format("strike(%d,%d)", this.attackPosition.getX(), this.attackPosition.getY()));

        for (int y = minY; y <= maxY; ++y) {
            for (int x = minX; x <= maxX; ++x) {
                if (!simulationManager.isValidPosition(x, y)) {
                    continue;
                }
                LinkedHashSet<Unit> units = simulationManager.getUnitsOnPosition(x, y);
                for (Unit unit : units) {
                    if (unit == this.attacker && this.canSelfAttack == false) {
                        continue;
                    }
                    System.out.println(String.format("(%c)%dzzz in (%d,%d)", unit.getSymbol(), unit.getHp(), x, y));
                    for (EUnitType unitType : this.canAttackUnitTypes) {
                        if (unitType == unit.getUnitType()) {
                            System.out.print(String.format("(%c)%d -> (%c)%d : ",
                                    attacker.getSymbol(), attacker.getHp(), unit.getSymbol(), unit.getHp()));
                            unit.onAttacked(calculateDamage(x, y));
                            attackedUnits.add(unit);
                            break;
                        }
                    }
                }
            }
        }
    }

    private int calculateDamage(final int unitX, final int unitY) {
        int strikeX = this.attackPosition.getX();
        int strikeY = this.attackPosition.getY();
        int distance = Math.max(Math.abs(unitY - strikeY), Math.abs(unitX - strikeX));
        int damage = (int) ((double) this.ap * (1.0 - (distance / ((double) this.areaOfEffect + 1.0))));
//      int damage = (int) ((double) this.ap * (1.0 - (distance / (double) this.areaOfEffect + 1.0)));
//        damage *= -1;
        System.out.print(damage);
        System.out.println(String.format("   strike(%d,%d) unit(%d,%d)", strikeX, strikeY, unitX, unitY));
        return damage;
    }
}
