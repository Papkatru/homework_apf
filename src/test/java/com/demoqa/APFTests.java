package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class APFTests {
    static APFData apfForm = new APFData();
    static APFPage apfPage = new APFPage();

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillAutomationPracticeForm() {
        open("/automation-practice-form");
        apfPage.fillAPFFormAndSubmit(apfForm);
        apfPage.checkEquals(apfForm);
    }
}
