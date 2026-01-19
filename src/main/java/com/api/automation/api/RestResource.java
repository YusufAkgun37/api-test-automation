package com.api.automation.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RestResource {

    public static Response post(String path, Object payload) {
        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(path)
                .then()
                .extract()
                .response();
    }

    public static Response get(String path) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(path);
    }

    public static Response put(String path, String token, Object payload) {
        return given()
                .contentType(ContentType.JSON)
                .cookie("token", token) // Auth token as cookie
                .body(payload)
                .when()
                .put(path)
                .then()
                .extract()
                .response();
    }

    public static Response delete(String path, String token) {
        return given()
                .contentType(ContentType.JSON)
                .cookie("token", token) // Auth token as cookie
                .when()
                .delete(path)
                .then()
                .extract()
                .response();
    }
}
