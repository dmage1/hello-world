package com.example.myproject.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.myproject.service.HelloService;

import javax.servlet.http.HttpServletResponse;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.concurrent.TimeUnit;

import static sun.net.www.protocol.http.HttpURLConnection.userAgent;

@RestController
public class HealthCheckController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HelloService service;

    /**
     * HealthCheck Controller.
     * e.g. http://localhost:8080/healthcheck
     *
     * @return String the string to return.
     */
    @RequestMapping("/healthcheck")
    @ResponseBody
    String healthcheck() {
        return getReadableUpTime();
    }

    private String getReadableUpTime() {
        final RuntimeMXBean mx = ManagementFactory.getRuntimeMXBean();
        final long millis = mx.getUptime();
        return String.format("Uptime %02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis) -
                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), TimeUnit.MILLISECONDS.toSeconds(millis) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
    }
}
