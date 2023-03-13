package lesson5;


import lesson5.dto.GetCategoryResponse;
import lesson5.servise.CategoryService;
import lesson5.util.RetrofitUtils;

import lombok.SneakyThrows;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import static org.hamcrest.MatcherAssert.assertThat;

public class GetCategoryTest {
    static CategoryService categoryService;
    @BeforeAll
    static void beforeAll() throws IOException {
        categoryService = RetrofitUtils.getRetrofit().create(CategoryService.class);
    }


    @Test
    void getCategoryByIdPositiveTest() throws IOException {
        Response<GetCategoryResponse> response = categoryService.getCategory(1).execute();

        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getId(), equalTo(1));
        assertThat(response.body().getTitle(), equalTo("Food"));
        response.body().getProducts().forEach(product ->
                assertThat(product.getCategoryTitle(), equalTo("Food")));


    }
}
