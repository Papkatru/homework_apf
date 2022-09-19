package com.demoqa;

import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.demoqa.APFElements.*;
import static com.demoqa.helper.Attachments.takeScreenshot;

public class APFPage {

    @Step("Удаление баннера")
    public void removeBanner() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }

    @Step("Заполнение имени")
    public void fillFirstName(APFData data) {
        firstName.setValue(data.firstName);
    }

    @Step("Заполнение фамилии")
    public void fillLastName(APFData data) {
        lastName.setValue(data.lastName);
    }

    @Step("Заполнение электронной почты")
    public void fillEmail(APFData data) {
        email.setValue(data.email);
    }

    @Step("Заполнение пола")
    public void fillGender(APFData data) {
        gender.find(new ByText(data.gender)).click();
    }

    @Step("Заполнение телефона")
    public void fillMobile(APFData data) {
        mobile.setValue(data.mobile);
    }

    @Step("Заполнение даты рождения")
    public void fillDateOfBirth(APFData data) {
        dateOfBirth.sendKeys(Keys.CONTROL + "a");
        dateOfBirth.sendKeys(data.dateOfBirth + Keys.ENTER);
    }

    @Step("Заполнение предметов")
    public void fillSubjects(APFData data) {
        for (String subject : data.subjects) {
            subjects.setValue(subject).pressEnter();
        }
    }

    @Step("Заполнение хобби")
    public void fillHobbies(APFData data) {
        hobbies.find(new ByText(data.hobbies)).click();
    }

    @Step("Загрузка изображения")
    public void fillPicture(APFData data) {
        picture.uploadFile(new File("src/test/resources/" + data.picture));
    }

    @Step("Заполнение адреса")
    public void fillCurrentAddress(APFData data) {
        currentAddress.setValue(data.currentAddress);
    }

    @Step("Заполнение штата")
    public void fillState(APFData data) {
        state.setValue(data.state).pressEnter();
    }

    @Step("Заполнение города")
    public void fillCity(APFData data) {
        city.setValue(data.city).pressEnter();
    }

    @Step("Заполнение формы")
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
        submitBtn.click();
        takeScreenshot();
    }

    @Step("Проверка формы")
    public void checkEquals(APFData data) {
        enteredStudentName.shouldHave(text(data.firstName + " " + data.lastName));
        enteredEmail.shouldHave(text(data.email));
        enteredGender.shouldHave(text(data.gender));
        enteredMobile.shouldHave(text(data.mobile));

        LocalDate date = LocalDate.parse(data.dateOfBirth, DateTimeFormatter.ofPattern("MM.dd.yyyy"));
        String changedDateOfBirth = date.format(DateTimeFormatter.ofPattern("dd MMMM,yyyy", new Locale("en")));
        enteredDateOfBirth.shouldHave(text(changedDateOfBirth));


        enteredSubject.shouldHave(text(data.subjects.toString().replace("[", "")
                .replace("]", "")));

        enteredHobbies.shouldHave(text(data.hobbies));
        enteredPicture.shouldHave(text(data.picture));
        enteredAddress.shouldHave(text(data.currentAddress));
        enteredStateAndCity.shouldHave(text(data.state + " " + data.city));
    }
}
