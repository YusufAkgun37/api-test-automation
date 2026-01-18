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
                .get(path)
                .then()
                .extract()
                .response();
    }

    public static Response put(String path, Object payload) {
        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .put(path)
                .then()
                .extract()
                .response();
    }

    public static Response delete(String path) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .delete(path)
                .then()
                .extract()
                .response();
    }
}
