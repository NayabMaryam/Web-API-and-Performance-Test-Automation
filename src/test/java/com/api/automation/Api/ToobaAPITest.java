package com.api.automation.Api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ToobaAPITest {

    static {
        RestAssured.baseURI = "https://dummyjson.com";
    }

    @Test(priority = 1)
    public void testGetUser() {
        given()
        .when()
            .get("/users/1")
        .then()
            .log().all()
            .statusCode(200)
            .body("firstName", notNullValue());
    }

    @Test(priority = 2)
    public void testCreateProduct() {
        String body = "{ \"title\": \"Tooba Product\" }";

        given()
            .header("Content-Type", "application/json")
            .body(body)
        .when()
            .post("/products/add")
        .then()
            .log().all()
            .statusCode(201)
            .body("title", equalTo("Tooba Product"));
    }

    @Test(priority = 3)
    public void testUpdateProduct() {
        String body = "{ \"title\": \"Updated Product\" }";

        given()
            .header("Content-Type", "application/json")
            .body(body)
        .when()
            .put("/products/1")
        .then()
            .log().all()
            .statusCode(200)
            .body("title", equalTo("Updated Product"));
    }

    @Test(priority = 4)
    public void testDeleteProduct() {
        given()
        .when()
            .delete("/products/1")
        .then()
            .log().all()
            .statusCode(200);
    }
}
