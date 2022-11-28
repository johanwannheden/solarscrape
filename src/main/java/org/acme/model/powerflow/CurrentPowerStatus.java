package org.acme.model.powerflow;

import java.util.Objects;

public final class CurrentPowerStatus {
    private final Double currentPower;
    private final String status;

    public CurrentPowerStatus(Double currentPower, String status) {
        this.currentPower = currentPower;
        this.status = status;
    }

    public Double currentPower() {
        return currentPower;
    }

    public String status() {
        return status;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (CurrentPowerStatus) obj;
        return Objects.equals(this.currentPower, that.currentPower) && Objects.equals(this.status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPower, status);
    }

    @Override
    public String toString() {
        return "CurrentPowerStatus[" + "currentPower=" + currentPower + ", " + "status=" + status + ']';
    }

}
