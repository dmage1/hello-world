package com.example.myproject.web;

import io.restassured.http.ContentType;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Import(MyTestsConfiguration.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerControllerTest {

    private int id = 1;
    private String firstname = "Bob";
    private String lastname = "Minion";
    private String address = "Gru Man Cave";
    private String email = "gru@secret.lair";
    private String phone = "0123456789";

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
        String url = String.format("/customer/save/id/%s/firstname/%s/lastname/%s/address/%s/email/%s/phone/%s", id, firstname, lastname, address, email, phone);
        given().when().get(url)
                .then()
                .body(containsString("{\"id\":1,\"firstname\":\"" + firstname
                        + "\",\"lastname\":\"" + lastname
                        + "\",\"address\":\"" + address
                        + "\",\"email\":\"" + email
                        + "\",\"phone\":\"" + phone + "\"}"))
                .statusCode(200);
    }

    @Test
    public void stage2_exampleRestTest() {
        given()
                .contentType(ContentType.JSON)
                .pathParam("id", 1).when()
                .get("/customer/get/{id}")
                .then()
                .statusCode(200)
                .body("id", greaterThanOrEqualTo(0))
                .body("firstname", equalTo(firstname))
                .body("lastname", equalTo(lastname))
                .body("address", equalTo(address))
                .body("email", equalTo(email))
                .body("phone", equalTo(phone));
    }

    @Test
    public void stage2_getId() {
        given().when().get("/customer/get/1")
                .then()
                .body("id", greaterThanOrEqualTo(0))
                .body("firstname", equalTo(firstname))
                .body("lastname", equalTo(lastname))
                .body("address", equalTo(address))
                .body("email", equalTo(email))
                .body("phone", equalTo(phone))
                .statusCode(200);
    }

    @Test
    public void stage3_getAll() {
        given().when().get("/customer/all")
                .then()
                .body(containsString("{\"id\":1,\"firstname\":\"" + firstname
                        + "\",\"lastname\":\"" + lastname
                        + "\",\"address\":\"" + address
                        + "\",\"email\":\"" + email
                        + "\",\"phone\":\"" + phone + "\"}"))
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
