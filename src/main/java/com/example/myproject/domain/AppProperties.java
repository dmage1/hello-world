package com.example.myproject.domain;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("app")
public class AppProperties {

    private boolean enabled;

    private String remoteAddress;

    private String security;

    private String message = "Hi AppProperties";

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    public String getSecurity() {
        return security;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
