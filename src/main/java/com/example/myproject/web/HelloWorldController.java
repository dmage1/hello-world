package com.example.myproject.web;

import com.example.myproject.domain.Greeting;
import com.example.myproject.service.HelloWorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/hello-world")
public class HelloWorldController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldController.class);
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private HelloWorldService service;

    /**
     * Say hello world.
     * http://localhost:8080/hello-world
     *
     * @param name the name to set
     * @return greeting
     */
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    Greeting sayHello(@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {
        return service.sayHello(counter.incrementAndGet(), String.format(template, name));
    }

}