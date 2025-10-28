package com.API.requestSpecificationUtils;

import com.API.config.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class RestUtil {
    private static final ConfigManager CONFIG_MANAGER = ConfigManager.getInstance();
    public static Response sendRequest(String endpoint, Method method) {
        return RestAssured
                .given()
                .auth()
                .preemptive()
                .basic(CONFIG_MANAGER.getProperty("userName"),CONFIG_MANAGER.getProperty("Password"))
                .spec(RequestSpecificationUtil.getRequestSpec())
                .when()
                .request(method, endpoint);
    }

    public static Response sendRequestWithBody(String endpoint, Method method, Object body) {
        return RestAssured
                .given()
                .auth()
                .preemptive()
                .basic(CONFIG_MANAGER.getProperty("userName"),CONFIG_MANAGER.getProperty("Password"))
                .spec(RequestSpecificationUtil.getRequestSpec())
                .body(body)
                .when()
                .request(method, endpoint);
    }
}
