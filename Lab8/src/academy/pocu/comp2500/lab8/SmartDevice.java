package academy.pocu.comp2500.lab8;

public abstract class SmartDevice {
    protected boolean on;
    protected int currentTick;
    protected int lastUpdatedTick;

    public SmartDevice() {
        this.on = false;
    }

    public boolean isOn() {
        return this.on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void onTick() {
        ++this.currentTick;
    }

    public int getTicksSinceLastUpdate() {
        return currentTick - lastUpdatedTick;
    }

    public abstract void onInstall(Planter planter);
}
