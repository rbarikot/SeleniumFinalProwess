package com.API.componentTest;

import com.API.pojoBuilder.ApplicationRequestPojo;
import com.API.utils.JsonUtil;
import com.API.utils.RestMethodUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;

import static com.API.constants.EndPoint.PUT_APPLICATION_REQUEST;

public class compPutCall extends BaseComponent {
    public compPutCall(){
        super();
    }
    public Response putApplicationRequest() throws JsonProcessingException {
        Response res= RestMethodUtil.putRequest(PUT_APPLICATION_REQUEST, JsonUtil.toJson(ApplicationRequestPojo.getApplicationRequest()));
        res.then().assertThat().statusCode(200);
        return res;
    }

}
