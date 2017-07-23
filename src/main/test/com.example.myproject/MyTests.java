package com.example.myproject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Import(MyTestsConfiguration.class)
public class MyTests {

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
        given().when().get("/hello-world").then().statusCode(200);
    }

    @Test
    public void getCustomerTest() {
        given().when().get("/customer/get/1")
                .then()
                .body(containsString("bob"))
                .statusCode(200);

        given().when().get("/customer/get/2")
                .then()
                .body(containsString("sue"))
                .statusCode(200);

        given().when().get("/customer/get/2")
                .then()
                .assertThat().body("content", equalTo("sue"))
                .statusCode(200);
    }
}
