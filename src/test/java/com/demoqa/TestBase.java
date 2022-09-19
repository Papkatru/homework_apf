package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.demoqa.helper.Attachments.takeScreenshot;
import static com.demoqa.helper.Attachments.takeSource;

public class TestBase {

    @BeforeAll
    @Step("Установка настроек браузера")
    static void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
        Configuration.baseUrl = "https://demoqa.com";
        SelenideLogger.addListener("allureTest", new AllureSelenide());
    }

    @AfterEach
    @Step("Получить аттачменты")
    void getAttachments(){
        takeScreenshot();
        takeSource();
    }
}
