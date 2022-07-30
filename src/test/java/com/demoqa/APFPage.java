package com.demoqa;

import com.codeborne.selenide.conditions.Text;
import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.Keys;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;

public class APFPage {

    public void fillFirstName(APFData data) {
        APFElements.firstName.setValue(data.firstName);
    }

    public void fillLastName(APFData data) {
        APFElements.lastName.setValue(data.lastName);
    }

    public void fillEmail(APFData data) {
        APFElements.email.setValue(data.email);
    }

    public void fillGender(APFData data) {
        APFElements.gender.find(new ByText(data.gender)).click();
    }

    public void fillMobile(APFData data) {
        APFElements.mobile.setValue(data.mobile);
    }

    public void fillDateOfBirth(APFData data) {
        APFElements.dateOfBirth.sendKeys(Keys.CONTROL + "a");
        APFElements.dateOfBirth.sendKeys(data.dateOfBirth + Keys.ENTER);
    }

    public void fillSubjects(APFData data) {
        for (int i = 0; i < data.subjects.length; i++) {
            APFElements.subjects.setValue(data.subjects[i]).pressEnter();
        }
    }

    public void fillHobbies(APFData data) {
        APFElements.hobbies.find(new ByText(data.hobbies)).click();
    }

    public void fillPicture(APFData data) {
        APFElements.picture.uploadFile(new File("src/test/resources/" + data.picture));
    }

    public void fillCurrentAddress(APFData data) {
        APFElements.currentAddress.setValue(data.currentAddress);
    }

    public void fillState(APFData data) {
        APFElements.state.setValue(data.state).pressEnter();
    }

    public void fillCity(APFData data) {
        APFElements.city.setValue(data.city).pressEnter();
    }

    public void fillAPFFormAndSubmit(APFData data) {
        fillFirstName(data);
        fillLastName(data);
        fillEmail(data);
        fillGender(data);
        fillMobile(data);
        fillDateOfBirth(data);
        fillSubjects(data);
        fillHobbies(data);
        fillPicture(data);
        fillCurrentAddress(data);
        fillState(data);
        fillCity(data);
        APFElements.submitBtn.click();
    }

    public void checkEquals(APFData data) {
        APFElements.enteredStudentName.shouldHave(new Text(data.firstName + " " + data.lastName));
        APFElements.enteredEmail.shouldHave(new Text(data.email));
        APFElements.enteredGender.shouldHave(new Text(data.gender));
        APFElements.enteredMobile.shouldHave(new Text(data.mobile));

        LocalDate date = LocalDate.parse(data.dateOfBirth, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        String changedDateOfBirth = date.format(DateTimeFormatter.ofPattern("dd MMMM,yyyy", new Locale("en")));
        APFElements.enteredDateOfBirth.shouldHave(new Text(changedDateOfBirth));

        APFElements.enteredSubject.shouldHave(new Text(Arrays.toString(data.subjects).replace("[", "")
                .replace("]", "")));

        APFElements.enteredHobbies.shouldHave(new Text(data.hobbies));
        APFElements.enteredPicture.shouldHave(new Text(data.picture));
        APFElements.enteredAddress.shouldHave(new Text(data.currentAddress));
        APFElements.enteredStateAndCity.shouldHave(new Text(data.state + " " + data.city));
    }
}
