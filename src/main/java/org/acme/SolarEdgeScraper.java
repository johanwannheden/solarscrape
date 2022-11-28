package org.acme;

import java.util.function.ToDoubleFunction;

import javax.enterprise.context.ApplicationScoped;

import org.acme.model.powerflow.SiteCurrentPowerFlow;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import io.quarkus.scheduler.Scheduled;

@ApplicationScoped
public class SolarEdgeScraper {

    private final SolarEdgeService solarEdgeService;

    private SiteCurrentPowerFlow currentPowerFlow;

    SolarEdgeScraper(MeterRegistry registry, SolarEdgeService solarEdgeService) {
        this.solarEdgeService = solarEdgeService;

        ToDoubleFunction<Tags> currentPowerLoadProvider = t -> currentPowerFlow.load().currentPower();
        registry.gauge("org.acme.current.power.load", Tags.empty(), currentPowerLoadProvider);

        ToDoubleFunction<Tags> currentPowerGridProvider = t -> currentPowerFlow.grid().currentPower();
        registry.gauge("org.acme.current.power.grid", Tags.empty(), currentPowerGridProvider);

        ToDoubleFunction<Tags> currentPowerPvProvider = t -> currentPowerFlow.pv().currentPower();
        registry.gauge("org.acme.current.power.pv", Tags.empty(), currentPowerPvProvider);
    }

    @Scheduled(every = "5m")
    @Counted
    void scrapeCurrentPowerFlow() {
        currentPowerFlow = solarEdgeService.getCurrentPowerFlow();
    }
}
