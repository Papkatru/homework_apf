package com.demoqa;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.List;

public class APFData {
    Faker faker = new Faker();
    SimpleDateFormat dateToString = new SimpleDateFormat("MM.dd.yyyy");

    List<String> subjects = List.of("Maths", "Physics", "Computer Science");
    String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Male",
            mobile = faker.phoneNumber().subscriberNumber(10),
            dateOfBirth = dateToString.format(faker.date().birthday()),
            hobbies = "Music",
            picture = "test upload.jpg",
            currentAddress = faker.address().streetAddress(),
            state = "NCR",
            city = "Noida";
}
