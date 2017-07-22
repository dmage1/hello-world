package com.example.myproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        LOG.info("Starting Application...");

        try {

            SpringApplication.run(Application.class, args);

        } catch (Exception ex) {
            LOG.error("Error ocured running Application...", ex);
            LOG.info("Shutting down...");
            System.exit(-1);
        }

    }

}
