package com.mohammadeko.postman.restassured.twentytwo;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestPatch {
    String endpoint = "https://mern-backend-8881.herokuapp.com/products/6306405fcd2ff4d2fcd68b83";

    @Test
    public void testPatchProductId() {
        JSONObject request = new JSONObject();
        request.put("name", "Mohammad Eko");
        request.put("category", "Bootcamp");
        request.put("price", 9000);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .patch(endpoint)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testValidasiPatch() {
        given()
                .get(endpoint)
                .then()
                .statusCode(200)
                .body("name", equalTo("Mohammad Eko"))
                .body("category", equalTo("Bootcamp"))
                .body("price", equalTo(9000));
    }
}
