package com.example.myproject.service;

import com.example.myproject.domain.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;


@Service
public class PropertyService {

    private static final Logger LOG = LoggerFactory.getLogger(PropertyService.class);

    private AppProperties properties;

    @Autowired
    public PropertyService(AppProperties properties) {
        this.properties = properties;
    }

    public String getMessage() {
        LOG.info("getMessage()");
        return properties.getMessage();
    }

}
