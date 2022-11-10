package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Sprinkler extends SmartDevice implements ISprayable {
    private Schedule activeScheduleOrNull;
    private final ArrayList<Schedule> schedules;
    private static final int SPRAY_WATER_LITER = 15;

    public Sprinkler() {
        this.activeScheduleOrNull = null;
        this.schedules = new ArrayList<>();
    }

    public void addSchedule(Schedule schedule) {
        this.schedules.add(schedule);
    }

    @Override
    public void spray(Planter planter) {
        if (this.isOn()) {
            planter.addWaterAmount(SPRAY_WATER_LITER);
        }
    }

    @Override
    public void onInstall(Planter planter) {
        planter.registerISprayable(this);
    }

    @Override
    public void onTick() {
        if (this.isOn()) {
            doOnLogic();
        } else {
            doOffLogic();
        }
        super.onTick();
    }

    private void doOffLogic() {
        if (this.schedules.size() == 0) {
            return;
        }
        while (this.schedules.get(0).getTickStartPoint() == 0 ||
                this.schedules.get(0).getTickEndPoint() <= this.currentTick + 1) {
            this.schedules.remove(0);
            if (this.schedules.size() == 0) {
                return;
            }
        }
        if (this.schedules.get(0).getTickStartPoint() == this.currentTick + 1) {
            this.activeScheduleOrNull = schedules.get(0);
            this.lastUpdatedTick = this.currentTick + 1;
            this.setOn(true);
        }
    }

    private void doOnLogic() {
        if (this.activeScheduleOrNull.getTickDuration() == this.getTicksSinceLastUpdate() + 1) {
            this.activeScheduleOrNull = null;
            this.lastUpdatedTick = this.currentTick + 1;
            this.schedules.remove(0);
            this.setOn(false);
        }
    }
}
