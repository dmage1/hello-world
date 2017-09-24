package com.example.myproject.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "app")
@Validated
// Spring Boot will attempt to validate @ConfigurationProperties classes whenever they are annotated with Spring’s @Validated
public class AppProperty {
    private static final long serialVersionUID = 1L;

    @NotNull
    private String name;
    @NotNull
    private String version;
    @NotNull
    private String description;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
