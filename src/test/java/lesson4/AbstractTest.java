package lesson4;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AbstractTest {

    protected static ResponseSpecification responseSpecification;
    protected static RequestSpecification requestSpecification;
    static Properties prop = new Properties();
    private static InputStream configfile;
    private static String apikey;

    private static String baseUrl;

    private static String username;
    private static String hash;

    private static String spoonacularPassword;




    @BeforeAll
    static void initTest() throws IOException {
        configfile = new FileInputStream("src/main/resources/my.properties");
        prop.load(configfile);

        apikey = prop.getProperty("apiKey");
        baseUrl = prop.getProperty("base_url");

        username = prop.getProperty("username");
        hash = prop.getProperty("hash");
        spoonacularPassword = prop.getProperty("spoonacularPassword");

        requestSpecification = new RequestSpecBuilder()
                .addQueryParam("apiKey", apikey)
                .addQueryParam("hash", hash)
                .build();


        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    public static String getApikey() {
        return apikey;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static String getUsername() {
        return username;
    }

    public static String getHash() {
        return hash;
    }

    public static String getSpoonacularPassword() {
        return spoonacularPassword;
    }

    public RequestSpecification getRequestSpecification(){
        return requestSpecification;
    }
}
