package com.ust.finalAssessment.config;

import io.github.cdimascio.dotenv.Dotenv;

public record DatabaseConfig(String jdbcUrl, String username, String password) {
    static Dotenv dotenv = Dotenv.load();


    public static DatabaseConfig fromEnvironmentCredential() {
        String jdbcUrl = required("DB_JDBC_URL");
        String username = required("DB_USER");
        String password = required("DB_PASSWORD");
        return new DatabaseConfig(jdbcUrl, username, password);
    }

    private static String required(String name) {
        String value = dotenv.get(name);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException("Missing required environment variable or system property: " + name);
        }
        return value;
    }
}