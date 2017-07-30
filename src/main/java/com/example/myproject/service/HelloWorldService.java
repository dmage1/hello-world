package com.example.myproject.service;

import com.example.myproject.domain.Greeting;
import com.example.myproject.web.CustomerController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldService.class);

    public Greeting sayHello(long id, String content) {
        LOG.info("sayHello({}, {})", id, content);
        return new Greeting(id, content);
    }

}