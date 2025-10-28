package com.API.utils;

import com.github.javafaker.Faker;

public class FakerUtils {
    private static final Faker faker = new Faker();
    public static String getRandomName() {
        return faker.name().fullName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomBusiness() {
        return faker.business().toString();
    }
    public static String getRandomDescription()
    {
        return faker.random().toString();
    }
    public static int getRandomAge() {
        return faker.number().numberBetween(0, 100);
    }
}
