package com.example.myproject.service;

import com.example.myproject.domain.AppProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppPropertyService {

    private static final Logger LOG = LoggerFactory.getLogger(AppPropertyService.class);

    private AppProperty appProperties;

    @Autowired
    public AppPropertyService(AppProperty appProperties) {
        this.appProperties = appProperties;
    }

    public String getName() {
        LOG.info("getName()");
        return appProperties.getName();
    }

    public String getVersion() {
        LOG.info("getVersion()");
        return appProperties.getVersion();
    }

    public String getDescription() {
        LOG.info("getDescription()");
        return appProperties.getDescription();
    }

    public String getMessage() {
        LOG.info("getMessage()");
        return appProperties.getMessage();
    }

    public AppProperty getAllProperties() {
        LOG.info("getAllProperties()");
        return appProperties;
    }
}
