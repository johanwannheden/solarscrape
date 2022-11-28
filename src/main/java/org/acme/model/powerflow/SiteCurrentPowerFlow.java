package org.acme.model.powerflow;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAlias;

public final class SiteCurrentPowerFlow {
    @JsonAlias("GRID")
    private final CurrentPowerStatus grid;
    @JsonAlias("LOAD")
    private final CurrentPowerStatus load;
    @JsonAlias("PV")
    private final CurrentPowerStatus pv;
    private final List<PowerConnection> connections;
    private final String unit;

    public SiteCurrentPowerFlow(@JsonAlias("GRID") CurrentPowerStatus grid, @JsonAlias("LOAD") CurrentPowerStatus load,
            @JsonAlias("PV") CurrentPowerStatus pv, List<PowerConnection> connections, String unit) {
        this.grid = grid;
        this.load = load;
        this.pv = pv;
        this.connections = connections;
        this.unit = unit;
    }

    @JsonAlias("GRID")
    public CurrentPowerStatus grid() {
        return grid;
    }

    @JsonAlias("LOAD")
    public CurrentPowerStatus load() {
        return load;
    }

    @JsonAlias("PV")
    public CurrentPowerStatus pv() {
        return pv;
    }

    public List<PowerConnection> connections() {
        return connections;
    }

    public String unit() {
        return unit;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (SiteCurrentPowerFlow) obj;
        return Objects.equals(this.grid, that.grid) && Objects.equals(this.load, that.load) && Objects.equals(this.pv, that.pv)
               && Objects.equals(this.connections, that.connections) && Objects.equals(this.unit, that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grid, load, pv, connections, unit);
    }

    @Override
    public String toString() {
        return "SiteCurrentPowerFlow[" + "grid=" + grid + ", " + "load=" + load + ", " + "pv=" + pv + ", " + "connections="
               + connections + ", " + "unit=" + unit + ']';
    }

}
