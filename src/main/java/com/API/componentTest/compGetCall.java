package com.API.componentTest;

import com.API.utils.ResponseValidatorUtil;
import com.API.utils.RestMethodUtil;
import io.restassured.response.Response;

import static com.API.constants.EndPoint.GET_APPLICATION_REQUEST_ALL;

public class compGetCall extends BaseComponent {
    public compGetCall() {
        super();
    }

    public Response getApplicationRequestCall()
    {
        Response res= RestMethodUtil.getRequest(GET_APPLICATION_REQUEST_ALL);
        ResponseValidatorUtil.validateStatusCode(res,200);
        return res;
    }
}
