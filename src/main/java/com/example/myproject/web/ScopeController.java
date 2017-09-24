package com.example.myproject.web;

import com.example.myproject.scope.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * http://javasampleapproach.com/spring-framework/spring-bean-scope-using-annotation-singleton-prototype-request-session-global-session-application
 * <p>
 * We annotate the classes which bean has scope by @Scope(value = [scope], proxyMode = ScopedProxyMode.TARGET_CLASS)
 * – Proxy Mode TARGET_CLASS: is used for creating AOP proxy of the bean. We must do it when injecting short lived bean scope (request, session…) to long lived bean
 * scope (singleton, prototype) or injecting prototype to singleton scope.
 * – We have some type of scope:
 * <p>
 * + singleton: only one instance is created (default scope)
 * + prototype: new instance is created everytime prototype bean is referenced.
 * + request: one instance for a single HTTP request.
 * + session: one instance for an HTTP Session
 * + globalSession: one instance for a global HTTP Session. Typically only valid when used in a Portlet context.
 * + application: Scopes a single bean definition to the lifecycle of a ServletContext (Only valid in the context of a web-aware Spring ApplicationContext).
 * <p>
 * To Test:-
 * <p>
 * + http://localhost:8080/scope/name
 * + http://localhost:8080/scope/namecheck
 * + http://localhost:8080/scope/language
 * + http://localhost:8080/scope/languagecheck
 * + http://localhost:8080/scope/address
 * + http://localhost:8080/scope/addresscheck
 * + http://localhost:8080/scope/age
 * + http://localhost:8080/scope/agecheck
 */
@RestController
@RequestMapping("/scope")
public class ScopeController {

    private static final Logger LOG = LoggerFactory.getLogger(ScopeController.class);

    @Autowired
    private Customer customer;

    @RequestMapping("/name")
    public String name() {
        LOG.info("name()");
        String result = customer.getCustomerName();
        customer.setCustomerName("Adam", "Johnson");
        return "init Data: " + result + "|-----| modified Data: " + customer.getCustomerName();
    }

    @RequestMapping("/namecheck")
    public String namecheck() {
        LOG.info("namecheck()");
        return "check Data: " + customer.getCustomerName();
    }

    @RequestMapping("/language")
    public String language() {
        LOG.info("language()");
        String result = customer.getCustomerLanguage();
        //customer.setCustomerLanguage("French"); //this command creates new instance of Language
        return "init Data: " + result + "|-----| modified Data: " + customer.setCustomerLanguage("French");
    }

    @RequestMapping("/languagecheck")
    public String languagecheck() {
        LOG.info("languagecheck()");
        return "check Data: " + customer.getCustomerLanguage();
    }

    @RequestMapping("/address")
    public String address() {
        LOG.info("address()");
        String result = customer.getCustomerAddress();
        customer.setCustomerAddress("EU");
        return "init Data: " + result + "|-----| modified Data: " + customer.getCustomerAddress();
    }

    @RequestMapping("/addresscheck")
    public String addresscheck() {
        LOG.info("addresscheck()");
        return "check Data: " + customer.getCustomerAddress();
    }

    @RequestMapping("/age")
    public String age() {
        LOG.info("age()");
        String result = customer.getCustomerAge();
        customer.setCustomerAge("25");
        return "init Data: " + result + "|-----| modified Data: " + customer.getCustomerAge();
    }

    @RequestMapping("/agecheck")
    public String agecheck() {
        LOG.info("agecheck()");
        return "check Data: " + customer.getCustomerAge();
    }

}
