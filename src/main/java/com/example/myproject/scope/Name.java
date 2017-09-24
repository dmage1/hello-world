package com.example.myproject.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * singleton: only one instance is created (default scope)
 */
@Scope(value = "singleton")
@Component
public class Name {

    private static final Logger LOG = LoggerFactory.getLogger(Name.class);

    private String firstName = "Jack";
    private String lastName = "Smith";

    public Name() {
        LOG.info("*** singleton: Create new Name: " + this.toString());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName();
    }

}

