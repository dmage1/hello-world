package com.example.myproject.web;

import com.example.myproject.domain.AppProperties;
import com.example.myproject.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService service;

    /**
     * Get Test.
     * e.g. http://localhost:8080/test/get
     *
     * @return the customer.
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    @ResponseBody
    String getTest() {
        LOG.info("getTest()");
        return service.test();
    }

    /**
     * Service Unavailable - test 5xx errors
     * e.g. http://localhost:8080/test/5xx
     *
     * @return 5xx errors.
     */
    @RequestMapping(value = "/5xx", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    public String ServiceUnavailable() {
        throw new RuntimeException("ABC");
    }

    /**
     * Service Unavailable - test 5xx errors
     * e.g. http://localhost:8080/test/5xx
     *
     * @return 5xx errors.
     */
    @RequestMapping(value = "/props", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    public String getProperty() {
        throw new RuntimeException("ABC");
    }

}
