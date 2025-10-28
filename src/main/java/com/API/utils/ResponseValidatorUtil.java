package com.API.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.testng.Assert;
import java.util.List;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.lessThan;

public class ResponseValidatorUtil {
    public static void validateStatusCode(Response response, int expectedStatus) {
        assertThat(response.getStatusCode(), is(equalTo(expectedStatus)));
        //Assert.assertEquals(response.statusCode(), expectedStatus);
    }

    public static void validateField(Response response, String jsonPath, Object expectedValue) {
        Assert.assertEquals(response.jsonPath().get(jsonPath), expectedValue);
    }

    public static void validateFieldContains(Response response, String jsonPath, String substring) {
        String actualValue = response.jsonPath().getString(jsonPath);
        Assert.assertEquals(actualValue, substring);

    }
    public static void validateListContainsAll(Response response, String jsonPath, Object... items) {
        List<Object> actualList = response.jsonPath().getList(jsonPath);
        assertThat(actualList, hasItems(items));
    }
    public static void validateListSize(Response response, String jsonPath, int expectedSize) {
        List<Object> actualList = response.jsonPath().getList(jsonPath);
        assertThat(actualList, hasSize(expectedSize));
    }
    public static void validateFieldNotNull(Response response, String jsonPath) {
        assertThat(response.jsonPath().get(jsonPath), notNullValue());
    }
    public static void validateFieldNull(Response response, String jsonPath) {
        assertThat(response.jsonPath().get(jsonPath), nullValue());
    }

    public static <T extends Comparable<T>> void validateGreaterThan(Response response, String jsonPath, T expected) {
        assertThat(response.jsonPath().get(jsonPath), greaterThan(expected));
    }

    public static <T extends Comparable<T>> void validateLessThan(Response response, String jsonPath, T expected) {
        assertThat(response.jsonPath().get(jsonPath), lessThan(expected));
    }

    public static void validateFieldMatches(Response response, String jsonPath, Matcher<?> matcher) {
        assertThat(response.jsonPath().get(jsonPath), matcher);
    }
}
