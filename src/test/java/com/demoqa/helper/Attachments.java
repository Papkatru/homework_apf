package com.demoqa.helper;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selenide.webdriver;
import static io.qameta.allure.Allure.attachment;

public class Attachments {

    @Step("Сделать скрин")
    @Attachment(value = "Screenshot name", type = "image/png", fileExtension = "png")
    public static byte[] takeScreenshot(){
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Step("Сохранить исходник страницы")
    public static void takeSource(){
        attachment("Source", webdriver().driver().source());
    }
}
