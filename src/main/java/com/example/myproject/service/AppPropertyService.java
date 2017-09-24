package com.example.myproject.service;

import com.example.myproject.domain.AppProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class AppPropertyService {

    private static final Logger LOG = LoggerFactory.getLogger(AppPropertyService.class);

    private AppProperty appProperty;

    @Autowired
    public AppPropertyService(AppProperty appProperty) {
        this.appProperty = appProperty;
    }

    public String getName() {
        LOG.info("getName()");
        return appProperty.getName();
    }

    public String getVersion() {
        LOG.info("getVersion()");
        return appProperty.getVersion();
    }

    public String getDescription() {
        LOG.info("getDescription()");
        return appProperty.getDescription();
    }

    // @Value is a core container feature and it does not provide the same features as type-safe Configuration Properties.
    @Value("${welcome.message}")
    private String message;

    public String getMessage() {
        LOG.info("getMessage()");
        return message;
    }

}
