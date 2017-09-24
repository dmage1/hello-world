package com.example.myproject.service;

import com.example.myproject.domain.AppProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class TestService {

    private static final Logger LOG = LoggerFactory.getLogger(TestService.class);

    private AppProperty properties;

    // inject via application.properties
    @Value("${welcome.message}")
    private String message = "Hello Test World";

    @Autowired
    public TestService(AppProperty properties) {
        this.properties = properties;
    }

    public String test() {
        LOG.info("test()");
        return message;
    }

}
