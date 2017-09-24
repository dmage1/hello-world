package com.example.myproject.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "app")
@Validated
// Spring Boot will attempt to validate @ConfigurationProperties classes whenever they are annotated with Spring’s @Validated
public class AppProperty implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("name")
    @NotNull
    private String name;
    @JsonProperty("version")
    @NotNull
    private String version;
    @JsonProperty("description")
    @NotNull
    private String description;
    @JsonProperty("message")
    @NotNull
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

    @Override
    public String toString() {
        return "AppProperty{" + "name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", description='" + description + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
