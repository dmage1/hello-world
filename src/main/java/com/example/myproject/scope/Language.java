package com.example.myproject.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * prototype: new instance is created everytime prototype bean is referenced.
 */
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class Language {

    private static final Logger LOG = LoggerFactory.getLogger(Language.class);

    private String language = "English";

    public Language() {
        LOG.info("*** prototype: Create new Language: " + this.language);
    }

    public String getLanguage() {
        return language;
    }

    public String setLanguage(String language) {
        this.language = language;
        return this.language;
    }

}
