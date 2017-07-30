package com.example.myproject.service;

import com.example.myproject.domain.Greeting;
import com.example.myproject.domain.HealthCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.concurrent.TimeUnit;

@Service
public class HealthCheckService {

    private static final Logger LOG = LoggerFactory.getLogger(HealthCheckService.class);

    public HealthCheck getHealthCheck() {
        return new HealthCheck(getReadableUpTime());
    }

    private String getReadableUpTime() {
        LOG.info("getReadableUpTime()");
        final RuntimeMXBean mx = ManagementFactory.getRuntimeMXBean();
        final long millis = mx.getUptime();
        return String.format("Uptime %02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis) -
                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), TimeUnit.MILLISECONDS.toSeconds(millis) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
    }

}
