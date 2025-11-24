package com.api.automation.Api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
//
//import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

public class ApiTest {

    static {
        // Base URI for ReqRes API
        RestAssured.baseURI = "https://reqres.in/api";
    }

    // ------------------ GET /users/2 ------------------
    @Test(priority = 1)
    public void testGetUser() {
//        given()
//        .when().get("/users/2")
//        .then().statusCode(200)
//        .and().body("data.id", equalTo(2));
//        System.out.println("GET /users/2 Passed");
    }

    // ------------------ POST /users ------------------
    @Test(priority = 2)
    public void testCreateUser() {
//        String jsonBody = "{ \"name\": \"Test\", \"job\": \"QA\" }";
//
//        given()
//            .header("Content-type", "application/json")
//            .body(jsonBody)
//        .when().post("/users")
//        .then().statusCode(201)
//        .and().body("name", equalTo("Test"));
//        System.out.println("POST /users Passed");
    }

    // ------------------ PUT /users/2 ------------------
    @Test(priority = 3)
    public void testUpdateUser() {
//        String jsonBody = "{ \"name\": \"Updated\", \"job\": \"Lead\" }";
//
//        given()
//            .header("Content-type", "application/json")
//            .body(jsonBody)
//        .when().put("/users/2")
//        .then().statusCode(200)
//        .and().body("name", equalTo("Updated"));
//        System.out.println("PUT /users/2 Passed");
    }

    // ------------------ DELETE /users/2 ------------------
    @Test(priority = 4)
    public void testDeleteUser() {
//        when().delete("/users/2")
//        .then().statusCode(204);
//        System.out.println("DELETE /users/2 Passed");
  
    }
}
//NOTES:
//  For running open terminal of project and type mvn clean test this will create a folder of surefire-reposts where you find the index.html 