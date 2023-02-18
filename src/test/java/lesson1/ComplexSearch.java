package lesson1;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ComplexSearch extends AbstractTest {

    @BeforeAll
    static void setUp(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void getAllRecipes (){
        given()
                .queryParam("apiKey", getApikey())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200);

    }
    @Test
    void getQueryRecipes (){
        given()
                .queryParam("apiKey", getApikey())
                .queryParam("query", "pasta")
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200);
    }
    @Test
    void getOverInfoRecipes (){
        given()
                .queryParam("apiKey", getApikey())
                .queryParam("addRecipeNutrition", true)   //или строка?
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200);
    }

    @Test
    void getMatchIngredientRecipes (){
        given()
                .queryParam("apiKey", getApikey())
                .queryParam("titleMatch", "banana")   //или строка?
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200);
    }
    @Test
    void getMatchListIngredientRecipes (){
        given()
                .queryParam("apiKey", getApikey())
                .queryParam("includeIngredients", "eggs,tomato")   //или строка?
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200);
    }

}
