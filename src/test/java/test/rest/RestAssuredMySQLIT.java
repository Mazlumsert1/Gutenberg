/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.rest;

import com.jayway.restassured.RestAssured;
import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.http.ContentType.JSON;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Private
 */
public class RestAssuredMySQLIT {

    public RestAssuredMySQLIT() {
    }

    @BeforeClass
    public static void setUpClass() {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = 8080;
        } else {
            RestAssured.port = Integer.valueOf(port);
        }

        String basePath = System.getProperty("server.base");
        if (basePath == null) {
            basePath = "/api/";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if (baseHost == null) {
            baseHost = "http://localhost";
        }
        RestAssured.baseURI = baseHost;
    }

    @Test
    public void testConnectionOpen() {
        given()
                .when()
                .get("mysql/test")
                .then()
                .statusCode(200);
    }

    @Test
    public void testGetCitiesFromBook() {
        given()
                .when()
                .get("mysql/frombook/Ivanhoe")
                .then()
                    .contentType(JSON)
                    .body("title", equalTo("Ivanhoe"))
                    .body("locations", hasSize(equalTo(287)))
                .statusCode(200);

    }
    
    @Test
    public void testGetAuthorsAndBooksFromCity() {
        // 134 books from Washington
        given()
                .when()
                .get("mysql/fromcity/Washington")
                .then()
                    .contentType(JSON)
                    .body("title", equalTo("Ivanhoe"))
                    .body("locations", hasSize(equalTo(287)))
                .statusCode(200);
    }
}
