package com.API.utils;

import com.API.exceptions.POJOException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    private static final ObjectMapper mapper = new ObjectMapper();
    public static String toJson(Object pojo) throws JsonProcessingException {
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pojo);
        } catch (JsonProcessingException e) {
            throw new POJOException("Failed to convert POJO to JSON", e);
        }
    }
}
