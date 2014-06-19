package com.github.jntakpe.bfbdemo.domain;

/**
 * DTO pour la websocket Hazelcast
 *
 * @author jntakpe
 */
public class HazelcastDTO {

    private final String host;

    private final int port;

    private final boolean local;

    public HazelcastDTO(String host, int port, boolean local) {
        this.host = host;
        this.port = port;
        this.local = local;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public boolean isLocal() {
        return local;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HazelcastDTO that = (HazelcastDTO) o;

        return port == that.port && !(host != null ? !host.equals(that.host) : that.host != null);

    }

    @Override
    public int hashCode() {
        int result = host != null ? host.hashCode() : 0;
        result = 31 * result + port;
        return result;
    }

    @Override
    public String toString() {
        return "HazelcastDTO{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", local=" + local +
                '}';
    }
}
