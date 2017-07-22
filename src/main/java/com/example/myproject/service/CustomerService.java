package com.example.myproject.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerService.class);

    public String getResponse() {
        LOG.info("getResponse()");
        return "Hello World!!!";
    }

}
