package com.discoveryserver.io.domain;

import java.util.Objects;

public record ServiceMetadata(
        String clusterId, // unique id
        String name,
        String ip,
        String port,
        String healthUrl,
        long lastHeartBeatTime
) {

    @Override
    public String clusterId() {
        return clusterId;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String ip() {
        return ip;
    }

    @Override
    public String port() {
        return port;
    }

    @Override
    public String healthUrl() {
        return healthUrl;
    }

    @Override
    public long lastHeartBeatTime() {
        return lastHeartBeatTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceMetadata that = (ServiceMetadata) o;
        return Objects.equals(clusterId, that.clusterId) && Objects.equals(name, that.name) && Objects.equals(ip, that.ip) && Objects.equals(port, that.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clusterId, name, ip, port);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ServiceMetadata{");
        sb.append("clusterId='").append(clusterId).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", ip='").append(ip).append('\'');
        sb.append(", port='").append(port).append('\'');
        sb.append(", healthUrl='").append(healthUrl).append('\'');
        sb.append(", lastHeartBeatTime=").append(lastHeartBeatTime);
        sb.append('}');
        return sb.toString();
    }
}
