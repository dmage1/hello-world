package com.example.myproject.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * request: one instance for a single HTTP request.
 */
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Address {

    private static final Logger LOG = LoggerFactory.getLogger(Address.class);

    private String address = "US";

    public Address() {
        LOG.info("*** request: Create new Address: " + this.address);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
