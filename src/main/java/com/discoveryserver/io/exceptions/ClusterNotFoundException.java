package com.discoveryserver.io.exceptions;

public class ClusterNotFoundException extends RuntimeException {

    public ClusterNotFoundException(String message) {
        super(message);
    }
}
