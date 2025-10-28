package com.API.requestSpecificationUtils;

import com.API.config.ConfigManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationUtil {

    private RequestSpecificationUtil() {

    }
    private static final ThreadLocal<RequestSpecification> requestSpecThreadLocal = new ThreadLocal<>();
    private static final ConfigManager CONFIG_MANAGER = ConfigManager.getInstance();
    public static RequestSpecification getRequestSpec() {
        if (requestSpecThreadLocal.get() == null) {
            RequestSpecification spec = new RequestSpecBuilder().setBaseUri(CONFIG_MANAGER.getProperty("baseURI")).build();
            requestSpecThreadLocal.set(spec);
        }
        return requestSpecThreadLocal.get();
    }
    public static void removeRequestSpec() {
        requestSpecThreadLocal.remove(); // clean up after thread finishes
    }
}
