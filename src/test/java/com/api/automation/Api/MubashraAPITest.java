package com.api.automation.Api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class MubashraAPITest {

    static {
        RestAssured.baseURI = "https://dummyjson.com";
    }

    // GET USER (User 3)
    @Test(priority = 1)
    public void testGetUser3() {
        given()
        .when()
            .get("/users/3")
        .then()
            .log().all()
            .statusCode(200)
            .body("firstName", notNullValue());
    }

    // POST - CREATE PRODUCT
    @Test(priority = 2)
    public void testCreateProduct() {
        String body = "{ \"title\": \"Mubashra Product\" }";

        given()
            .header("Content-Type", "application/json")
            .body(body)
        .when()
            .post("/products/add")
        .then()
            .log().all()
            .statusCode(201)
            .body("title", equalTo("Mubashra Product"));
    }

    // PUT - UPDATE PRODUCT
    @Test(priority = 3)
    public void testUpdateProduct() {
        String body = "{ \"title\": \"Updated Mubashra Product\" }";

        given()
            .header("Content-Type", "application/json")
            .body(body)
        .when()
            .put("/products/3")
        .then()
            .log().all()
            .statusCode(200)
            .body("title", equalTo("Updated Mubashra Product"));
    }

    // DELETE PRODUCT
    @Test(priority = 4)
    public void testDeleteProduct() {
        given()
        .when()
            .delete("/products/3")
        .then()
            .log().all()
            .statusCode(200);
    }
}
