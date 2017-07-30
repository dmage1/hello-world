package com.example.myproject.domain;

import java.io.Serializable;

public class HealthCheck implements Serializable {
    private static final long serialVersionUID = 1L;

    private String upTime;

    public HealthCheck(String upTime) {
        this.upTime = upTime;
    }

    public String getUpTime() {
        return upTime;
    }

    public void setUpTime(String upTime) {
        this.upTime = upTime;
    }

}
