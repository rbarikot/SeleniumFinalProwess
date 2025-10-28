package com.API.pojoBuilder;

import com.API.pojo.ApplicationRequest;
import com.API.utils.FakerUtils;

public class ApplicationRequestPojo {

    public static ApplicationRequest getApplicationRequest()
    {
        return ApplicationRequest.builder().name(FakerUtils.getRandomName()).description(FakerUtils.getRandomDescription()).notificationSchemeId("00000000-0000-0000-0000-000000000000").build();
    }
}
