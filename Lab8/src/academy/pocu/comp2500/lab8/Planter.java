package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Planter {
    private int waterAmount;
    private final ArrayList<SmartDevice> smartDevices;
    private final ArrayList<ISprayable> iSprayables;
    private final ArrayList<IDrainable> iDrainables;
    private final ArrayList<IWaterDetectable> iWaterDetectables;
    private static final int CONSUME_WATER_LITER = 2;

    public Planter(int waterAmount) {
        this.waterAmount = waterAmount;
        this.smartDevices = new ArrayList<>();
        this.iSprayables = new ArrayList<>();
        this.iDrainables = new ArrayList<>();
        this.iWaterDetectables = new ArrayList<>();
    }

    public int getWaterAmount() {
        return this.waterAmount;
    }

    public void addWaterAmount(int waterAmount) {
        this.waterAmount += waterAmount;
    }

    public void reduceWaterAmount(int waterAmount) {
        this.waterAmount -= waterAmount;
        this.waterAmount = Math.max(this.waterAmount, 0);
    }

    public void installSmartDevice(SmartDevice smartDevice) {
        this.smartDevices.add(smartDevice);
        smartDevice.onInstall(this);
    }

    public void registerISprayable(ISprayable iSprayable) {
        this.iSprayables.add(iSprayable);
    }

    public void registerIDrainable(IDrainable iDrainable) {
        this.iDrainables.add(iDrainable);
    }

    public void registerIWaterDetectable(IWaterDetectable iWaterDetectable) {
        this.iWaterDetectables.add(iWaterDetectable);
    }

    public void tick() {
        for (IWaterDetectable waterDetectable : this.iWaterDetectables) {
            waterDetectable.detect(this.waterAmount);
        }
        for (SmartDevice smartDevice : this.smartDevices) {
            smartDevice.onTick();
        }
        for (ISprayable sprayable : this.iSprayables) {
            sprayable.spray(this);
        }
        for (IDrainable drainable : this.iDrainables) {
            drainable.drain(this);
        }
        reduceWaterAmount(CONSUME_WATER_LITER);
    }
}
