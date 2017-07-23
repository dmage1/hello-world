package com.example.myproject.web;

import com.example.myproject.Application;
import com.example.myproject.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.myproject.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService service;

    @RequestMapping(value = "/ex", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    public String ex() {
        throw new RuntimeException("Application Error");
    }

    /**
     * Get Customer.
     * e.g. http://localhost:8080/customer/get/1
     *
     * @return the customer.
     */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    @ResponseBody
    Customer getCustomer(@PathVariable final int id) {
        LOG.info("getCustomer()");
        return service.getCustomer(id);
    }

    /**
     * Get Customers.
     * e.g. http://localhost:8080/customer/all
     *
     * @return the list of customers
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    @ResponseBody
    List<Customer> getCustomers() {
        LOG.info("getCustomers()");
        return service.getCustomers();
    }

    /**
     * Save Customer.
     * e.g. http://localhost:8080/customer/save/1/Bobby
     */
    @RequestMapping(value = "/save/{id}/{content}", method = RequestMethod.GET)
    @ResponseBody
    List<Customer> save(@PathVariable final int id, @PathVariable final String content) {
        LOG.info("save()");
        return service.saveCustomer(new Customer(id, content));
    }
}
