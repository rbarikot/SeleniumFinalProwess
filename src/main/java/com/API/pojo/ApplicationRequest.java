package com.API.pojo;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ApplicationRequest {
    private String name;
    private String description;
    private String notificationSchemeId;
}
