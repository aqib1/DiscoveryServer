package com.discoveryserver.io.cache;

import com.discoveryserver.io.domain.ServiceMetadata;

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public non-sealed class MetadataCache implements Cache<String, ServiceMetadata> {
    private static final Long MAX_CACHE_LIMIT = Long.MAX_VALUE;
    private final ConcurrentMap<String, List<ServiceMetadata>> cache;

    public MetadataCache(ConcurrentMap<String, List<ServiceMetadata>> cache) {
        this.cache = cache;
    }

    @Override
    public void put(String key, ServiceMetadata value) {
      this.cache.computeIfAbsent(key, k -> new CopyOnWriteArrayList<>())
              .add(value);
    }

    public List<ServiceMetadata> getByCluster(String key) {
        return this.cache.get(key);
    }

    @Override
    public ServiceMetadata get(String key) {
        return this.cache.get(key).get(0);
    }

    public void remove(String key, ServiceMetadata metadata) {
        this.cache.get(key).remove(metadata);
    }

    @Override
    public void remove(String key) {
        this.cache.remove(key);
    }

    @Override
    public int size() {
        return this.cache.size();
    }

    @Override
    public Long maxSize() {
        return MAX_CACHE_LIMIT;
    }

    @Override
    public void clear() {
        this.cache.clear();
    }
}
