package com.mohammadeko.postman.restassured.twentytwo;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.Collections;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestDelete {

    String endpoint = "https://mern-backend-8881.herokuapp.com/products/6305d2f28651f7a4134afac3";

    @Test
    public void testDelete() {
        when()
                .delete(endpoint)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testValidasiDelete() {
        given()
                .get(endpoint)
                .then()
                .statusCode(200)
                .body(notNullValue(), equalTo("null"));
    }
}
