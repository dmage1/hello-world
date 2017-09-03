package com.example.myproject.service;

import com.example.myproject.domain.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;


@Service
public class TestService {

    private static final Logger LOG = LoggerFactory.getLogger(TestService.class);

    private AppProperties properties;

    // inject via application.properties
    @Value("${welcome.message}")
    private String message = "Hello Test World";

    @Autowired
    public TestService(AppProperties properties) {
        this.properties = properties;
    }

    public String test() {
        LOG.info("test()");
        return message;
    }

}
