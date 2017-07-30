package com.example.myproject.web;

import com.example.myproject.domain.Greeting;
import com.example.myproject.service.HelloWorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        LOG.info("sayHello({})", name);
        long id = counter.incrementAndGet();
        String content = String.format(template, name);
        return service.sayHello(id, content);
    }

    /**
     * Say hello world.
     * http://localhost:8080/hello-world/name/Bob
     *
     * @param name the name to set
     * @return greeting
     */
    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public @ResponseBody
    Greeting sayHi(@PathVariable(value = "name") String name) {
        LOG.info("sayHi({})", name);
        long id = counter.incrementAndGet();
        String content = String.format(template, name);
        return service.sayHello(id, content);
    }
}