package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.acme.model.powerflow.SiteCurrentPowerFlowContainer;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
public interface SolarEdgeRestClient {
    @Path("site/{siteId}/currentPowerFlow")
    @GET
    SiteCurrentPowerFlowContainer getSiteCurrentPowerFlowContainer(
            @PathParam("siteId") Integer siteId,
            @QueryParam("api_key") String apiKey
    );
}
