package com.API.Test;

import com.API.componentTest.compGetCall;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TestGetCall {

    @Test
    public void testGetCall(){
        final compGetCall cp=new compGetCall();
        Response res=cp.getApplicationRequestCall();
        System.out.println(res.getStatusCode());
    }
}
