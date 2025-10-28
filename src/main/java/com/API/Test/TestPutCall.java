package com.API.Test;

import com.API.componentTest.compGetCall;
import com.API.componentTest.compPutCall;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TestPutCall {

    @Test
    public void testGetCall() throws JsonProcessingException {
        final compPutCall cp=new compPutCall();
        Response res=cp.putApplicationRequest();
        System.out.println(res.getStatusCode());
    }
}
