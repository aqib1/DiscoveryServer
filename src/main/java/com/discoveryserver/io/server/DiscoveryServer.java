package com.discoveryserver.io.server;

import com.discoveryserver.io.domain.ServiceMetadata;

import java.util.List;

public sealed interface DiscoveryServer permits DefaultDiscoverServer {
    /**
     * This method is used to register service to our
     * discovery server.
     *
     * @param serviceMetadata metadata of service
     */
    void registerService(ServiceMetadata serviceMetadata);

    /**
     * This method is used to fetch registry.
     *
     * @param clusterId cluster id key
     * @return all services against cluster.
     */
    List<ServiceMetadata> fetchRegistry(String clusterId);

    /**
     * This method is used by services to send heart beat to
     * discovery server.
     *
     * @param metadata service metadata
     */
    void sendHeartBeat(ServiceMetadata metadata);
}
