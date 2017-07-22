package com.example.myproject.service;

import com.example.myproject.web.CustomerController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private static final Logger LOG = LoggerFactory.getLogger(HelloService.class);

    public String getResponse() {
        LOG.info("getResponse()");
        return "Hello World!!!";
    }

}