package com.ust.finalAssessment.support;

import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class SpecFactory {
    static Dotenv dotenv =Dotenv.load();

    public static final String BASE_URL =dotenv.get("BASE_URL");

    public static RequestSpecification authLoginRequest =new RequestSpecBuilder()
            .setBaseUri(BASE_URL)
            .setBasePath("/api")
            .addHeader("Content-Type","application/json")
            .build();




    public static RequestSpecification commonJsonRequest =
            new RequestSpecBuilder()
                    .setBaseUri(BASE_URL)
                    .setBasePath("/api")
                    .addHeader("Content-Type","application/json")
                    .build();

}
