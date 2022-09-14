package ru.netology.rest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class PostmanEchoTest {
    @Test
    void shouldPostPostman() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("14.09.2022")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("14.09.2022"))
        ;
    }

    @Test
    void shouldPostPostman2() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Иван")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data",equalTo("Иван"))
        ;
    }
}
