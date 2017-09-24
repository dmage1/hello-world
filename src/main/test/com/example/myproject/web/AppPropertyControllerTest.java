package com.example.myproject.web;

import com.example.myproject.domain.AppProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;
import static org.testng.AssertJUnit.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Import(MyTestsConfiguration.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppPropertyControllerTest {

    @Test
    public void testAppPropertyName() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/property/name")
                .then()
                .statusCode(200)
                .body(containsString("MyApp"));
    }

    @Test
    public void testAppPropertyVersion() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/property/version")
                .then()
                .statusCode(200)
                .body(containsString("1.0"));
    }

    @Test
    public void testAppPropertyDescription() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/property/description")
                .then()
                .statusCode(200)
                .body(containsString("MyApp is a Spring Boot application - 1.0"));
    }

    @Test
    public void whenUsingJsonProperty_thenCorrect() throws IOException {
        AppProperty appPropertyBean = new AppProperty();
        appPropertyBean.setName("name");
        appPropertyBean.setVersion("version");
        appPropertyBean.setDescription("description");
        appPropertyBean.setMessage("message");

        String result = new ObjectMapper().writeValueAsString(appPropertyBean);


        assertThat(result, containsString("name"));
        assertThat(result, containsString("version"));

        AppProperty resultBean = new ObjectMapper()
                .readerFor(AppProperty.class)
                .readValue(result);
        assertEquals("name", resultBean.getName());
        assertEquals("version", resultBean.getVersion());
        assertEquals("description", resultBean.getDescription());
        assertEquals("message", resultBean.getMessage());
    }

}
