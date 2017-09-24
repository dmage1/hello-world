package com.example.myproject.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * session: one instance for an HTTP Session
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Age {

    private static final Logger LOG = LoggerFactory.getLogger(Age.class);

    private String age = "24";

    public Age() {
        LOG.info("*** session: Create new Age: " + this.age);
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
