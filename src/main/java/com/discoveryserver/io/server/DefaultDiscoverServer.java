package com.discoveryserver.io.server;

import com.discoveryserver.io.cache.MetadataCache;
import com.discoveryserver.io.domain.ServiceMetadata;

import java.util.List;

// Client-side discovery server implementations
public non-sealed class DefaultDiscoverServer implements DiscoveryServer {
    private final MetadataCache metadataCache;

    public DefaultDiscoverServer(MetadataCache cache) {
        this.metadataCache = cache;
    }

    @Override
    public void registerService(ServiceMetadata serviceMetadata) {
        this.metadataCache.put(serviceMetadata.clusterId(), serviceMetadata);
    }

    @Override
    public List<ServiceMetadata> fetchRegistry(String clusterId) {
        return this.metadataCache.getByCluster(clusterId);
    }

    @Override
    public void sendHeartBeat(ServiceMetadata metadata) {
        this.metadataCache.getByCluster(metadata.clusterId())
                .removeIf((m) -> m.name().equals(metadata.name()));

        this.metadataCache.getByCluster(metadata.clusterId())
                .add(metadata);
    }
}
