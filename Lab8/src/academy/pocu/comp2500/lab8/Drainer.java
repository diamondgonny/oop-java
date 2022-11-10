package academy.pocu.comp2500.lab8;

public class Drainer extends SmartDevice implements IWaterDetectable, IDrainable {
    private int waterDetected;
    private final int waterThreshold;
    private static final int DRAIN_WATER_LITER = 7;

    public Drainer(int waterThreshold) {
        this.waterThreshold = waterThreshold;
    }

    @Override
    public void detect(final int waterLevel) {
        this.waterDetected = waterLevel;
    }

    @Override
    public void drain(Planter planter) {
        if (this.isOn()) {
            planter.reduceWaterAmount(DRAIN_WATER_LITER);
        }
    }

    @Override
    public void onInstall(Planter planter) {
        planter.registerIWaterDetectable(this);
        planter.registerIDrainable(this);
    }

    @Override
    public void onTick() {
        if (this.waterDetected >= this.waterThreshold) {
            if (!this.isOn()) {
                this.lastUpdatedTick = this.currentTick + 1;
                this.setOn(true);
            }
        } else {
            if (this.isOn()) {
                this.lastUpdatedTick = this.currentTick + 1;
                this.setOn(false);
            }
        }
        super.onTick();
    }
}
