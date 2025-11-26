package com.api.automation.Api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class NayabAPITest {

    static {
        // Sets the base URL for all API requests
        RestAssured.baseURI = "https://dummyjson.com";
    }

    // Test Case 1: Validates GET /posts/1 returns correct post details
    @Test(priority = 1)
    public void testGetPost() {
        given()
        .when()
            .get("/posts/1")
        .then()
            .log().all()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("title", notNullValue())
            .body("body", notNullValue())
            .body("userId", notNullValue());
    }

    // Test Case 2: Validates POST /posts/add successfully creates a new post
    @Test(priority = 2)
    public void testCreatePost() {
        String jsonBody = "{ \"title\": \"Nayab Test\", \"body\": \"Created via API\", \"userId\": 1 }";

        given()
            .header("Content-Type", "application/json")
            .body(jsonBody)
        .when()
            .post("/posts/add")   // Correct endpoint for DummyJSON
        .then()
            .log().all()
            .statusCode(201)
            .body("title", equalTo("Nayab Test"))
            .body("body", equalTo("Created via API"));
    }

    // Test Case 3: Validates PUT /posts/1 updates the post successfully
    @Test(priority = 3)
    public void testUpdatePost() {
        String jsonBody = "{ \"title\": \"Updated Title\", \"body\": \"Updated Content\" }";

        given()
            .header("Content-Type", "application/json")
            .body(jsonBody)
        .when()
            .put("/posts/1")
        .then()
            .log().all()
            .statusCode(200)
            .body("title", equalTo("Updated Title"));
    }

    // Test Case 4: Validates DELETE /posts/1 deletes the post successfully
    @Test(priority = 4)
    public void testDeletePost() {
        given()
        .when()
            .delete("/posts/1")
        .then()
            .log().all()
            .statusCode(200);   // DummyJSON DELETE returns 200
    }
}