package org.acme;

import javax.enterprise.context.ApplicationScoped;

import org.acme.model.powerflow.SiteCurrentPowerFlow;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class SolarEdgeService {
    @RestClient
    SolarEdgeRestClient solarEdgeRestClient;

    @ConfigProperty(name = "siteId")
    Integer siteId;

    @ConfigProperty(name = "apikey")
    String apiKey;

    SiteCurrentPowerFlow getCurrentPowerFlow() {
        var siteCurrentPowerFlowContainer = solarEdgeRestClient.getSiteCurrentPowerFlowContainer(siteId, apiKey);
        return siteCurrentPowerFlowContainer.siteCurrentPowerFlow();
    }
}
