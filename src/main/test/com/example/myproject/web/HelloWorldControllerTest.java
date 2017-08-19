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
public class HelloWorldControllerTest {

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
    public void getHelloWorld() {

        given().when().get("/hello-world")
                .then()
                //.body(containsString("{\"id\":3,\"content\":\"Hello, Stranger!\"}"))
                .body(containsString("\"content\":\"Hello, Stranger!\"}"))
                .statusCode(200);

    }

    @Test
    public void getHelloWorld_With_Minion() {

        given().when().get("/hello-world/name/Minion")
                .then()
                .body(containsString("\"content\":\"Hello, Minion!\"}"))
                .statusCode(200);

    }

}
