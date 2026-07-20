package com.ust.finalAssessment.api.client;

import io.restassured.response.Response;

import java.util.Map;

import static com.ust.finalAssessment.support.SpecFactory.*;
import static io.restassured.RestAssured.given;

public class AuthClient {

    public Response login(String email,
                          String password) {

        return given()
                .spec(authLoginRequest)
                .body(Map.of(
                        "email", email,
                        "password", password
                ))
                .when()
                .post("/auth/login");
    }

    public Response authMe(String token)
    {
        return given()
                .spec(commonJsonRequest)
                .header("Authorization", "Bearer "+token)
                .when()
                .get("/auth/me");
    }

}