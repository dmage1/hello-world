package com.example.myproject.web;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Import(MyTestsConfiguration.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerControllerTest {

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
        given().when().get("/customer/ex").then().statusCode(400);
    }

    @Test
    public void getCustomerExTest() {
        given().when().get("/customer/ex")
                .then()
                .body(containsString("{\"message\":\"Application Error\"}"))
                .statusCode(400);
    }

    @Test
    public void stage1_save() {
        given().when().get("/customer/save/1/Dee")
                .then()
                .body(containsString("{\"id\":1,\"content\":\"Dee\"}"))
                .statusCode(200);
    }

    @Test
    public void stage2_getId() {
        given().when().get("/customer/get/1")
                .then()
                .body(containsString("{\"id\":1,\"content\":\"Dee\"}"))
                .statusCode(200);
    }

    @Test
    public void stage3_getAll() {
        given().when().get("/customer/all")
                .then()
                .body(containsString("{\"id\":1,\"content\":\"Dee\"}"))
                .statusCode(200);
    }

    @Test
    public void stage4_delete() {
        given().when().get("/customer/delete/1")
                .then()
                .body(containsString("[]"))
                .statusCode(200);
    }

}
