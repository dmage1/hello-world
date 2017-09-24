package com.example.myproject.web;

import com.example.myproject.domain.AppProperty;
import com.example.myproject.service.AppPropertyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/property")
public class AppPropertyController {

    private static final Logger LOG = LoggerFactory.getLogger(AppPropertyController.class);

    @Autowired
    private AppPropertyService service;

    /**
     * Get Application Property Name
     * .
     * e.g. http://localhost:8080/property/name
     *
     * @return the name.
     */
    @RequestMapping(value = "/name", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    @ResponseBody
    String getName() {
        LOG.info("getName()");
        return service.getName();
    }

    /**
     * Get Application Property Version
     * .
     * e.g. http://localhost:8080/property/version
     *
     * @return the version.
     */
    @RequestMapping(value = "/version", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    @ResponseBody
    String getVersion() {
        LOG.info("getVersion()");
        return service.getVersion();
    }

    /**
     * Get Application Property Description
     * .
     * e.g. http://localhost:8080/property/description
     *
     * @return the message.
     */
    @RequestMapping(value = "/description", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    @ResponseBody
    String getDescription() {
        LOG.info("getDescription()");
        return service.getDescription();
    }

    /**
     * Get Application Property Message
     * .
     * e.g. http://localhost:8080/property/message
     *
     * @return the message.
     */
    @RequestMapping(value = "/message", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    @ResponseBody
    String getTest() {
        LOG.info("getMessage()");
        return service.getMessage();
    }

}
