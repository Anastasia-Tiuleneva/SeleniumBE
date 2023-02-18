package lesson1;

import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AbstractTest {
    static Properties prop = new Properties();
    private static InputStream configfile;
    private static String apikey;

    private static String baseUrl;

    @BeforeAll
    static void initTest() throws IOException {
        configfile = new FileInputStream("src/main/resources/my.properties");
        prop.load(configfile);

        apikey = prop.getProperty("apiKey");
        baseUrl = prop.getProperty("base_url");

    }

    public static String getApikey() {
        return apikey;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }
}
