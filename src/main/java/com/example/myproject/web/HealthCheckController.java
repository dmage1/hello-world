package com.example.myproject.web;

import com.example.myproject.domain.HealthCheck;
import com.example.myproject.service.HealthCheckService;
import com.example.myproject.service.HelloWorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.concurrent.TimeUnit;

@RestController
public class HealthCheckController {

    private static final Logger LOG = LoggerFactory.getLogger(HealthCheckController.class);
    @Autowired
    private HealthCheckService service;

    /**
     * HealthCheck Controller.
     * e.g. http://localhost:8080/healthcheck
     *
     * @return String the string to return.
     */
    @RequestMapping("/healthcheck")
    public @ResponseBody
    HealthCheck healthcheck() {
        LOG.info("healthcheck()");
        return service.getHealthCheck();
    }
}
