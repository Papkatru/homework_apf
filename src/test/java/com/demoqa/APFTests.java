package com.demoqa;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

@Tag("APF")
public class APFTests extends TestBase {
    static APFData apfForm = new APFData();
    static APFPage apfPage = new APFPage();

    @Test
    @Epic("Заполнение форм")
    @Feature("Проверка заполнения")
    @Story("Заполнение практической формы")
    @Owner("Papkatru")
    @Severity(SeverityLevel.MINOR)
    @Link(value = "Demo QA", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Заполнение и проверка практической формы")
    void fillAutomationPracticeForm() {
        System.out.println(Configuration.remote);
        open("/automation-practice-form");
        apfPage.removeBanner();
        apfPage.fillAPFFormAndSubmit(apfForm);
        apfPage.checkEquals(apfForm);
    }
}
