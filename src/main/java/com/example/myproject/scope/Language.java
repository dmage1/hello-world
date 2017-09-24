package com.example.myproject.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * prototype: new instance is created everytime prototype bean is referenced.
 */
@Component
@Scope(value = "prototype")
public class Language {

    private static final Logger LOG = LoggerFactory.getLogger(Language.class);

    private String lang = "English";

    public Language() {
        LOG.info("*** prototype: Create new Language: " + lang);
    }

    public String getLanguage() {
        return this.lang;
    }

    public void setLanguage(String language) {
        this.lang = language;
    }

}
