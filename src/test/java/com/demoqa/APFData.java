package com.demoqa;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;

public class APFData {
    Faker faker = new Faker();
    SimpleDateFormat dateToString = new SimpleDateFormat("MM.dd.yyyy");

    String[] subjects = {"Maths", "Physics", "Computer Science"};
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

    public APFData(String firstName, String lastName, String email, String gender, String mobile, String dateOfBirth,
                   String[] subjects, String hobbies, String picture, String currentAddress, String state, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.mobile = mobile;
        this.dateOfBirth = dateOfBirth;
        this.subjects = subjects;
        this.hobbies = hobbies;
        this.picture = picture;
        this.currentAddress = currentAddress;
        this.state = state;
        this.city = city;
    }

    public APFData() {
    }
}
