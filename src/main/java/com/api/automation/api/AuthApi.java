package com.api.automation.api;

import java.util.HashMap;
import java.util.Map;
import io.restassured.response.Response;

public class AuthApi {

    public static String getToken() {
        Map<String, String> payload = new HashMap<>();
        payload.put("username", "admin");
        payload.put("password", "password123");

        Response response = RestResource.post("/auth", payload);
        return response.jsonPath().getString("token");
    }
}
