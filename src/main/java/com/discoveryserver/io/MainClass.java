package com.discoveryserver.io;

import com.discoveryserver.io.cache.MetadataCache;
import com.discoveryserver.io.domain.ServiceMetadata;
import com.discoveryserver.io.server.DefaultDiscoverServer;
import com.discoveryserver.io.server.DiscoveryServer;

import java.util.concurrent.ConcurrentHashMap;

public class MainClass {
    public static void main(String[] args) {
        MetadataCache metadataCache = new MetadataCache(new ConcurrentHashMap<>());

        DiscoveryServer server = new DefaultDiscoverServer(metadataCache);

        server.registerService(new ServiceMetadata(
                "C1",
                "s1",
                "127.0.0.1",
                "32",
                "https://test",
                39192091
        ));

        server.registerService(new ServiceMetadata(
                "C1",
                "s2",
                "127.0.0.1",
                "31",
                "https://test",
                39192092
        ));

        server.registerService(new ServiceMetadata(
                "C1",
                "s3",
                "127.0.0.1",
                "38",
                "https://test",
                39192099
        ));

        System.out.println(server.fetchRegistry("C1"));

        server.sendHeartBeat(new ServiceMetadata(
                "C1",
                "s2",
                "127.0.0.1",
                "38",
                "https://test",
                49192099
        ));

        System.out.println(server.fetchRegistry("C1"));
    }
}
