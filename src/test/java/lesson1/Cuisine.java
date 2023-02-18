package lesson1;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Cuisine extends AbstractTest {

    @BeforeAll
    static void setUp(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void getCuisineTittle (){
        given()
                .queryParam("apiKey", getApikey())
                .queryParam("title", "sushi")
                .when()
                .get(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);
    }
    @Test
    void getCuisineTittleAndIngredient (){
        given()
                .queryParam("apiKey", getApikey())
                .queryParam("title", "sushi")
                .queryParam("ingredientList", "fish")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);
    }

    @Test
    void getCuisine (){
        given()
                .queryParam("apiKey", getApikey())
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);
    }

    @Test
    void getCuisineEmptyTittle (){
        given()
                .queryParam("apiKey", getApikey())
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);
    }
    @Test
    void getCuisineIngredient (){
        given()
                .queryParam("apiKey", getApikey())
                .queryParam("ingredientList", "fish")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);
    }
}
