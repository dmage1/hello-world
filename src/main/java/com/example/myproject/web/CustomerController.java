package com.example.myproject.web;

import com.example.myproject.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.myproject.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService service;

    /**
     * Customer Controller.
     * <p>
     * e.g. http://localhost:8080/customer/hello
     *
     * @return String the string to return.
     */
    @RequestMapping(value = "/hello")
    @ResponseBody
    String home() {
        LOG.info("home()");
        return service.getResponse();
    }

}
