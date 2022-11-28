package org.acme.model.powerflow;

import java.util.Objects;

public final class SiteCurrentPowerFlowContainer {
    private final SiteCurrentPowerFlow siteCurrentPowerFlow;

    public SiteCurrentPowerFlowContainer(SiteCurrentPowerFlow siteCurrentPowerFlow) {
        this.siteCurrentPowerFlow = siteCurrentPowerFlow;
    }

    public SiteCurrentPowerFlow siteCurrentPowerFlow() {
        return siteCurrentPowerFlow;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (SiteCurrentPowerFlowContainer) obj;
        return Objects.equals(this.siteCurrentPowerFlow, that.siteCurrentPowerFlow);
    }

    @Override
    public int hashCode() {
        return Objects.hash(siteCurrentPowerFlow);
    }

    @Override
    public String toString() {
        return "SiteCurrentPowerFlowContainer[" + "siteCurrentPowerFlow=" + siteCurrentPowerFlow + ']';
    }

}
