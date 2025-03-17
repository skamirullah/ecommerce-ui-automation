package com.opencart.utility;

import com.github.javafaker.Faker;
import com.opencart.pojo.Address;

import java.util.Locale;

public class FakerUtil {

    //Using country and state as string as faker doesn't have mapping in built for these
    private static final String COUNTRY = "India";
    private static final String STATE = "Orissa";

    public static void main(String[] args) {
        getFakeAddress();
    }

    public static Address getFakeAddress() {
        Faker faker = new Faker(new Locale("en-IND"));

        return new Address(faker.name().firstName(), faker.name().lastName(),
                faker.company().name(), faker.address().buildingNumber(),
                faker.address().streetAddress(), faker.address().city(), faker.address().zipCode(), COUNTRY, STATE);
    }
}
