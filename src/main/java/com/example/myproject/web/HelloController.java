package com.example.myproject.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.myproject.service.HelloService;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HelloService service;

    /**
     * Hello World Controller.
     * <p>
     * e.g. http://localhost:8080/hello/world
     *
     * @return String the string to return.
     */
    @RequestMapping("/world")
    @ResponseBody
    String home() {
        LOG.info("home()");
        return service.getResponse();
    }

}