package com.API.utils;

import com.API.exceptions.APIException;
import com.API.requestSpecificationUtils.RestUtil;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class RestMethodUtil {
    public static Response getRequest(String endpoint)
    {
        try
        {
            Response response = RestUtil.sendRequest(endpoint, Method.GET);
            if(response.statusCode() != 200 && response.statusCode() != 201)
            {
                throw new APIException("API returned error with HTTP status code: " + response.statusCode());
            }
            return response;
        }
        catch(Exception e)
        {
            throw new APIException("GET request failed for: " +endpoint,e);
        }

    }
    public static Response putRequest(String endpoint,Object body)
    {
        try
        {
            Response response = RestUtil.sendRequestWithBody(endpoint, Method.PUT,body);
            if(response.statusCode() != 200 && response.statusCode() != 201 && response.statusCode() != 204)
            {
                throw new APIException("API returned error with HTTP status code: " + response.statusCode());
            }
            return response;
        }
        catch(Exception e)
        {
            throw new APIException("PUT request failed for: " +endpoint,e);
        }
    }
    public static Response postRequest(String endpoint,Object body)
    {
        try
        {
            Response response = RestUtil.sendRequestWithBody(endpoint, Method.POST, body);
            if(response.statusCode() != 200 && response.statusCode() != 201)
            {
                throw new APIException("API returned error with HTTP status code: " + response.statusCode());
            }
            return response;
        }
        catch(Exception e)
        {
            throw new APIException("POST request failed for: " +endpoint,e);
        }
    }
    public static Response deleteRequest(String endpoint)
    {
        try
        {
            Response response = RestUtil.sendRequest(endpoint, Method.DELETE);
            if(response.statusCode() != 200 && response.statusCode() != 201 && response.statusCode() != 204)
            {
                throw new APIException("API returned error with HTTP status code: " + response.statusCode());
            }
            return response;
        }
        catch(Exception e)
        {
            throw new APIException("DELETE request failed for: " +endpoint,e);
        }
    }
}
