package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.demoqa.helper.Attachments.*;

public class TestBase {

    @BeforeAll
    @Step("Установка настроек браузера")
    static void setup() {
        SelenideLogger.addListener("allureTest", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @AfterEach
    @Step("Получить аттачменты")
    void getAttachments(){
        takeScreenshot();
        addSource();
        addHTMLSource();
        addBrowserConsoleLog();
        addVideo();
    }
}
