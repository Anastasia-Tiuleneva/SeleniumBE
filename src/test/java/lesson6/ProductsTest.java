package lesson6;


import lesson5.dto.Product;
import lesson5.servise.ProductService;
import lesson5.util.RetrofitUtils;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ProductsTest {
    static ProductService productService;

    static Product product = new Product(null, "Bread", 100, "Food");
    static Product product2 = new Product(1, "Bread", 100, "Food");

    static int newId;
    @BeforeAll
    static void beforeAll() throws IOException {
        productService = RetrofitUtils.getRetrofit().create(ProductService.class);
    }


    @Test
    void getCProductsByIdPositiveTest() throws IOException {
        Response<Product> response = productService.getProductById(1).execute();

        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getId(), equalTo(1));
        assertThat(response.body().getTitle(), equalTo("Milk"));
    }

    @Test
    void createProductsPositiveTest() throws IOException {
        Response<Product> response = productService.createProduct(product).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        newId = response.body().getId();
    }


    @Test
    void modifyProductsPositiveTest() throws IOException {
        Response<Product> response = productService.modifyProduct(product2).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }


    @Test
    void getProductsPositiveTest() throws IOException {
        Response<ResponseBody> response = productService.getProducts().execute();
        assertThat(response.code(), CoreMatchers.is(200));
    }


    @Test
    void deleteProductsPositiveTest() throws IOException {
        createProductsPositiveTest();
        Response<ResponseBody> response = productService.deleteProduct(newId).execute();
        assertThat(response.code(), CoreMatchers.is(200));
    }



}
