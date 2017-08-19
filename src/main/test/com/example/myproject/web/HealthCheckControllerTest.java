package com.example.myproject.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Import(MyTestsConfiguration.class)
public class HealthCheckControllerTest {

    @Test
    public void exampleTest() {
        assertTrue(true);
    }

    @Test
    public void makeSureThatGoogleIsUp() {
        given().when().get("http://www.google.com").then().statusCode(200);
    }

    @Test
    public void restAssuredTest() {
        given().when().get("/healthcheck").then().statusCode(200);
    }

    @Test
    public void getCustomerTest() {
        given().when().get("/healthcheck")
                .then()
                .body(containsString("Uptime"))
                .statusCode(200);
    }
}
