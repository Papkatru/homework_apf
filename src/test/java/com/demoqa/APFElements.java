package com.demoqa;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;

import static com.codeborne.selenide.Selenide.$;

public class APFElements {
    static SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            email = $("#userEmail"),
            gender = $("#genterWrapper"),
            mobile = $("#userNumber"),
            dateOfBirth = $("#dateOfBirthInput"),
            subjects = $("#subjectsInput"),
            hobbies = $("#hobbiesWrapper"),
            picture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#react-select-3-input"),
            city = $("#react-select-4-input"),
            submitBtn = $("#submit"),
            enteredStudentName = $(".modal-body").find(new ByText("Student Name")).parent().lastChild(),
            enteredEmail = $(".modal-body").find(new ByText("Student Email")).parent().lastChild(),
            enteredGender = $(".modal-body").find(new ByText("Gender")).parent().lastChild(),
            enteredMobile = $(".modal-body").find(new ByText("Mobile")).parent().lastChild(),
            enteredDateOfBirth = $(".modal-body").find(new ByText("Date of Birth")).parent().lastChild(),
            enteredSubject = $(".modal-body").find(new ByText("Subjects")).parent().lastChild(),
            enteredHobbies = $(".modal-body").find(new ByText("Hobbies")).parent().lastChild(),
            enteredPicture = $(".modal-body").find(new ByText("Picture")).parent().lastChild(),
            enteredAddress = $(".modal-body").find(new ByText("Address")).parent().lastChild(),
            enteredStateAndCity = $(".modal-body").find(new ByText("State and City")).parent().lastChild();
}