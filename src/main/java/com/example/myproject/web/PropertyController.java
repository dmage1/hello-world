package com.example.myproject.web;

import com.example.myproject.service.PropertyService;
import com.example.myproject.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/property")
public class PropertyController {

    private static final Logger LOG = LoggerFactory.getLogger(PropertyController.class);

    @Autowired
    private PropertyService service;

    /**
     * Get My Configuration App Properties.
     * e.g. http://localhost:8080/property/get
     *
     * @return the message.
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    @ResponseBody
    String getTest() {
        LOG.info("getMessage()");
        return service.getMessage();
    }

}
