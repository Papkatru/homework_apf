package com.demoqa;

public class APFData {
    String[] subjects = {"Maths", "Physics", "Computer Science"};
    String
            firstName = "Дмитрий",
            lastName = "Тестов",
            email = "testmail@dt.com",
            gender = "Male",
            mobile = "9112425378",
            dateOfBirth = "01.01.1990",
            hobbies = "Music",
            picture = "test upload.jpg",
            currentAddress = "Random street",
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
