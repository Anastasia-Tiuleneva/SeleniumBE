package lesson4;

import io.restassured.RestAssured;
import lesson4dto.request.AddShoppingListRequest;
import lesson4dto.response.AddShoppingListResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class ShoppingList extends AbstractTest{

    AddShoppingListRequest listJson = new AddShoppingListRequest("1 package baking powder", "Baking", true);
    int a;



    @BeforeAll
    static void setUp(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void addShoppingList(){
        AddShoppingListResponse response =
                given()
                .spec(requestSpecification)
                .queryParam("hash", getHash())
                .queryParam("apiKey", getApikey())
                .body(listJson)
                .when()
                .post(getBaseUrl() + getUsername()  + "/shopping-list/items")
                .then()
                .extract()
                        .body()
                        .as(AddShoppingListResponse.class);
            a = response.getId();
    }

    @Test
    void getShoppingList() {
        given().spec(requestSpecification)
                .when()
                .get(getBaseUrl() + getUsername() + "/shopping-list")
                .then()
                .spec(responseSpecification);
    }
    @Test
    void deleteShoppingList() {
        addShoppingList();
        given().spec(requestSpecification)
                .when()
                .delete(getBaseUrl() + getUsername()  + "/shopping-list/items/" + a)
                .then()
                .spec(responseSpecification);
    }
}
