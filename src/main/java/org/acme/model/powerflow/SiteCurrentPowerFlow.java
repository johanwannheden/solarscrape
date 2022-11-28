package org.acme.model.powerflow;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

public record SiteCurrentPowerFlow(@JsonAlias("GRID") CurrentPowerStatus grid, @JsonAlias("LOAD") CurrentPowerStatus load,
                                   @JsonAlias("PV") CurrentPowerStatus pv, List<PowerConnection> connections, String unit) {
}
